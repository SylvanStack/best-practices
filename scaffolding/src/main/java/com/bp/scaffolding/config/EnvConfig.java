package com.bp.scaffolding.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description: 环境配置
 * @author: hansiyuan
 * @date: 2022/3/2 4:23 PM
 */
@Configuration
@PropertySource("classpath:config.properties")
@Getter
public class EnvConfig {

    @Value("${env}")
    private String env;

    /**
     * 日常环境
     */
    public boolean isDaily() {
        return "daily".equals(this.env);
    }

    /**
     * 预发布/仿真环境
     */
    public boolean isPrepub() {
        return "prepub".equals(this.env);
    }

    /**
     * 是否生产
     */
    public boolean isProduct() {
        return "product".equals(this.env);
    }
}
