package com.bp.scaffolding.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnvConfigTest {
    @Resource
    private  EnvConfig envConfig;

    @Test
    void getEnv() {
        System.out.println(envConfig.getEnv());
    }
}