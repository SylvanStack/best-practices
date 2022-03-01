package com.bp.core.advance.jvm.classloader;

import java.util.Base64;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        String source = "Compiled from \"Hello.java\"\n" +
                "public class com.bp.core.advance.jvm.classloader.Hello {\n" +
                "  public com.bp.core.advance.jvm.classloader.Hello();\n" +
                "  static {};\n" +
                "}";
        String encode = Base64.getEncoder().encodeToString(source.getBytes());
        System.out.println(encode);
        try {
            new HelloClassLoader().findClass("com.bp.core.advance.jvm.classloader.Hello").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
//        String helloBase64 = "Q29tcGlsZWQgZnJvbSAiSGVsbG8uamF2YSIKcHVibGljIGNsYXNzIGNvbS5icC5jb3JlLmFkdmFuY2UuanZtLmNsYXNzbG9hZGVyLkhlbGxvIHsKICBwdWJsaWMgY29tLmJwLmNvcmUuYWR2YW5jZS5qdm0uY2xhc3Nsb2FkZXIuSGVsbG8oKTsKICBzdGF0aWMge307Cn0=";
//        byte[] bytes = decode(helloBase64);
        String source = "public class com.bp.core.advance.jvm.classloader.Hello {\n" +
                "  public com.bp.core.advance.jvm.classloader.Hello();\n" +
                "  static {};\n" +
                "}";
        byte[] bytes = source.getBytes();

        // 将字节数组转换为类的实例。
        return defineClass(name, bytes, 0, bytes.length);
    }

    private static byte[] decode(String helloBase64) {
        return Base64.getDecoder().decode(helloBase64);
    }
}
