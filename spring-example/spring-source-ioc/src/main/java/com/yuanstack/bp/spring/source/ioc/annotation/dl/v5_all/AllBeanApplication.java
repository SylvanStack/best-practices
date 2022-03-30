package com.yuanstack.bp.spring.source.ioc.annotation.dl.v5_all;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:45
 */
public class AllBeanApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dl/withAnno.xml");
        String[] beanNames = ctx.getBeanDefinitionNames();
        // 利用jdk8的Stream快速编写打印方法
        Stream.of(beanNames).forEach(System.out::println);
    }
}
