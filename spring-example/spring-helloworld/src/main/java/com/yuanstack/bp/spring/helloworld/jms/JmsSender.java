package com.yuanstack.bp.spring.helloworld.jms;

import com.yuanstack.bp.spring.helloworld.spring01.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:17
 */
public class JmsSender {

    public static void main( String[] args )
    {
        Student student2 = Student.create();

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:jms-sender.xml");

        SendService sendService = (SendService)context.getBean("sendService");

        sendService.send(student2);

        System.out.println("send successfully, please visit http://localhost:8161/admin to see it");
    }

}
