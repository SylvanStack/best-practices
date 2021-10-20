package com.example.demo.business.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @description: 文件编码问题：文件读写需要确保字符编码一致
 * @author: hansiyuan
 * @date: 2021/10/18 8:02 下午
 */
@Slf4j
public class FileEncodingIssue {

    private static final String PATH = "files/hello.txt";
    private static final String PATH2 = "files/hello2.txt";

    public static void main(String[] args) throws IOException {
        init();
        wrong();
        right1();
        right2();
    }

    public static void init() throws IOException {
        Files.deleteIfExists(Paths.get(PATH));
        Files.write(Paths.get(PATH), "你好,Jerry".getBytes(Charset.forName("GBK")));
        log.info("bytes:{}", Hex.encodeHexString(Files.readAllBytes(Paths.get(PATH))).toUpperCase());
    }

    public static void wrong() throws IOException {
        log.info("charset: {}", Charset.defaultCharset());

        char[] chars = new char[10];
        StringBuilder content = new StringBuilder();
        try (FileReader fileReader = new FileReader(PATH)) {
            int count;
            while ((count = fileReader.read(chars)) != -1) {
                content.append(new String(chars, 0, count));
            }
        }
        log.info("result:{}", content);
        Files.write(Paths.get(PATH2), "你好,Jerry".getBytes(StandardCharsets.UTF_8));
        log.info("bytes:{}", Hex.encodeHexString(Files.readAllBytes(Paths.get(PATH2))).toUpperCase());
    }

    public static void right1() throws IOException {
        char[] chars = new char[10];
        StringBuilder content = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(PATH);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("GBK"))) {
            int count;
            while ((count = inputStreamReader.read(chars)) != -1) {
                content.append(new String(chars, 0, count));
            }
        }

        log.info("result: {}", content);
    }

    public static void right2() throws IOException {
        log.info("result: {}", Files.readAllLines(Paths.get(PATH), Charset.forName("GBK")).stream().findFirst().orElse(""));
    }
}
