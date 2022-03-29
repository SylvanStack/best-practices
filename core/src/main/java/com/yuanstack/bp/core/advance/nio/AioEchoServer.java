package com.yuanstack.bp.core.advance.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Future;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author hansiyuan
 * @date 2022年03月11日 22:44
 */
public class AioEchoServer {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8003));
        System.out.println("端口8003服务开启");
        serverSocketChannel.accept(null, new
                CompletionHandler<AsynchronousSocketChannel, Object>() {
                    @Override
                    public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {
                        try {
                            System.out.println("接收新的链接: " +  socketChannel.getRemoteAddress());
                            serverSocketChannel.accept(null, this);
                            while (true) {
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                Future<Integer> future = socketChannel.read(buffer);
                                if (future.get() > 0) {
                                    buffer.flip();
                                    byte[] bytes = new byte[buffer.remaining()];
                                    buffer.get(bytes);
                                    String content = new String(bytes, UTF_8);
                                    if ("\r\n".equals(content)) {
                                        continue;
                                    }
                                    System.out.println("接收新的消息: " + content);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        System.out.println("失败");
                    }
                });
        System.in.read();
    }
}
