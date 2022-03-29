package com.yuanstack.bp.dubbo.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author hansiyuan
 */
@SpringBootApplication(scanBasePackages = "com.yuanstack.bp.dubbo.demo.consumer")
@ImportResource({"classpath:spring-dubbo-consumer.xml"})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
