package com.yuanstack.bp.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hansiyuan
 */
@SpringBootApplication
//@EnableJms    //启动消息队列
//@EnableMongoRepositories
public class HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }

}
