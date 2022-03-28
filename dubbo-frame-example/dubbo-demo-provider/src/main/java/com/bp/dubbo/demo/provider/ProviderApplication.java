package com.bp.dubbo.demo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author hansiyuan
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.bp.dubbo.demo")
@ImportResource({"classpath:spring.xml", "classpath:spring-dubbo-provider.xml"})
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
