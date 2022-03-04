package com.bp.scaffolding.config;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;

/**
 * @description: 配置数据加密
 * @author: hansiyuan
 * @date: 2022/3/4 2:11 PM
 */
public class JasyptTest {
    @Test
    public void jasyptTest() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的密钥
        textEncryptor.setPassword("123456");
        //要加密的数据（数据库的用户名或密码）
        String username = textEncryptor.encrypt("mysql");
        String password = textEncryptor.encrypt("123455");
        String url = textEncryptor.encrypt("jdbc:mysql://127.0.0.1:3306/scaffolding?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("url:" + url);
    }
}
