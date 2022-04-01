package com.yuanstack.bp.spring.helloworld.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:03
 */
public class JmsReceiver {

    public static void main( String[] args ) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jms-receiver.xml");

        System.in.read();

        System.out.println("send successfully, please visit http://localhost:8161/admin to see it");
    }

}
