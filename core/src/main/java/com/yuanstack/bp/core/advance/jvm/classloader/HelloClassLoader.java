package com.yuanstack.bp.core.advance.jvm.classloader;

import java.util.Base64;


/**
 * @description: 自定义类加载器
 * @author: hansiyuan
 * @date: 2022/3/3 11:00 AM
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            new HelloClassLoader().findClass("com.yuanstack.bp.core.advance.jvm.classloader.Hello").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        // 字节码base64编码后字符串
        String helloBase64 = "Q29tcGlsZWQgZnJvbSAiSGVsbG8uamF2YSIKcHVibGljIGNsYXNzIGNvbS5icC5jb3JlLmFkdmFuY2UuanZtLmNsYXNzbG9hZGVyLkhlbGxvIHsKICBwdWJsaWMgY29tLmJwLmNvcmUuYWR2YW5jZS5qdm0uY2xhc3Nsb2FkZXIuSGVsbG8oKTsKICBzdGF0aWMge307Cn0=";
        // 编码为字节数组
        byte[] bytes = decode(helloBase64);
        // 将字节数组转换为类的实例。
        return defineClass(name, bytes, 0, bytes.length);
    }

    private static byte[] decode(String helloBase64) {
        return Base64.getDecoder().decode(helloBase64);
    }
}
