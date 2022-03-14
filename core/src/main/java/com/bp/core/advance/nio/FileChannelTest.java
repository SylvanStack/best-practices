package com.bp.core.advance.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author hansiyuan
 * @date 2022年03月11日 23:08
 */
public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        FileChannel fileChannel = new RandomAccessFile("D:\\MyCode\\MyGithub\\best-practices\\docs\\gc.demo.log","rw").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ((fileChannel.read(buffer)) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                int remain = buffer.remaining();
                byte[] bytes = new byte[remain];
                buffer.get(bytes);
                System.out.println(new String(bytes, StandardCharsets.UTF_8));
            }
            buffer.clear();
        }
    }
}
