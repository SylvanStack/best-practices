package com.yuanstack.bp.scaffolding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 脚手架启动类
 * @author hansiyuan
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.yuanstack.bp.scaffolding.mapper"})
public class ScaffoldingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScaffoldingApplication.class, args);
    }

}
