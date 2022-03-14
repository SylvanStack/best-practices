package com.bp.core.advance.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hansiyuan
 * @date 2022年03月11日 22:47
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel)
                            selectionKey.channel();
                    SocketChannel socketChannel = ssc.accept();
                    System.out.println("接收新的链接: " +
                            socketChannel.getRemoteAddress());
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    ChatHolder.join(socketChannel);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel)
                            selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int length = socketChannel.read(buffer);
                    if (length > 0) {
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        String content = new String(bytes, StandardCharsets.UTF_8).replace("\r\n", "");
                        if ("quit".equalsIgnoreCase(content)) {
                            ChatHolder.quit(socketChannel);
                            selectionKey.cancel();
                            socketChannel.close();
                        } else {
                            ChatHolder.propagate(socketChannel, content);
                        }
                    }
                } iterator.remove();
            }
        }
    }

    private static class ChatHolder {
        private static final Map<SocketChannel, String> USER_MAP = new
                ConcurrentHashMap<>();

        public static void join(SocketChannel socketChannel) {
            String userId = "用户" + ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
            send(socketChannel, "您的id为：" + userId + "\n\r");
            for (SocketChannel channel : USER_MAP.keySet()) {
                send(channel, userId + " 加入了群聊" + "\n\r");
            }
            USER_MAP.put(socketChannel, userId);
        }

        public static void quit(SocketChannel socketChannel) {
            String userId = USER_MAP.get(socketChannel);
            send(socketChannel, "您退出了群聊" + "\n\r");
            USER_MAP.remove(socketChannel);
            for (SocketChannel channel : USER_MAP.keySet()) {
                if (channel != socketChannel) {
                    send(channel, userId + " 退出了群聊" + "\n\r");
                }
            }
        }

        public static void propagate(SocketChannel socketChannel, String content) {
            String userId = USER_MAP.get(socketChannel);
            for (SocketChannel channel : USER_MAP.keySet()) {
                if (channel != socketChannel) {
                    send(channel, userId + ": " + content + "\n\r");
                }
            }
        }

        private static void send(SocketChannel socketChannel, String msg) {
            try {
                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                writeBuffer.put(msg.getBytes());
                writeBuffer.flip();
                socketChannel.write(writeBuffer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
