package com.yuanstack.bp.core.advance.jdk8.functional;

import java.io.IOException;

/**
 * @author hansiyuan
 * @date 2022年03月28日 23:19
 */
public class FileServiceMain {
    public static void main(String[] args) throws IOException {
        FileService fileService = new FileService();

        String filePath = "D:\\MyCode\\MyGithub\\best-practices\\core\\src\\main\\java\\com\\bp\\core\\advance\\jdk8\\functional\\FileServiceMain.java";

        // 通过lambda表达式，打印文件内容
        fileService.fileHandle(filePath, System.out::println);
    }
}
