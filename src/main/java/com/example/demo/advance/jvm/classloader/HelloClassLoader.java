package com.example.demo.advance.jvm.classloader;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Base64;

/**
 * @description: 自定义类加载器
 * @author: hansiyuan
 * @date: 2021/10/15 10:31 上午
 */
@Slf4j
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            new HelloClassLoader().findClass("com.example.demo.advance.jvm.classloader.Hello").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
//        String helloBase64 = "";
//
//        byte[] bytes = decode(helloBase64);
        String path = "/Users/hansiyuan/MyCode/demo/target/classes/com/example/demo/advance/jvm/classloader/HelloW.class";
        byte[] bytes = new byte[]{};
        try {
            bytes = customLoadClass(path);
        } catch (Exception ex) {
            log.info("findClassException:", ex);
        }
        // 将字节数组转换为类的实例。
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] decode(String helloBase64) {
        return Base64.getDecoder().decode(helloBase64);
    }

    private byte[] customLoadClass(String route) throws FileNotFoundException {
        File file = new File(route);
        if (!file.exists()) {
            throw new FileNotFoundException("File Not Found:" + route);
        }
        try (FileInputStream inputStream = new FileInputStream(file);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[8192];
            int bytesNumRead = 0;
            while ((bytesNumRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesNumRead);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
