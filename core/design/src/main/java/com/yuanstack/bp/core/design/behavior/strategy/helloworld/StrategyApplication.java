package com.yuanstack.bp.core.design.behavior.strategy.helloworld;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @description: 策略的使用
 * @author: hansiyuan
 * @date: 2022/3/15 10:12 AM
 */
public class StrategyApplication {

    public static void main(String[] args) throws Exception {
        runtimeByProperties();
        noRuntime();
    }

    private static void noRuntime() {
        StrategyExample strategyExample = new ConcreteStrategyExampleA();
        strategyExample.algorithm();
    }

    private static void runtimeByProperties() throws Exception {
        StrategyExample strategyExample = null;
        Properties props = new Properties();
        props.load(new FileInputStream("/Users/hansiyuan/MyCode/my-project/best-practices/core/design/src/main/resources/config.properties"));
        String type = props.getProperty("strategy.type");
        strategyExample = StrategyFactoryV2.getStrategy(type);
        strategyExample.algorithm();
    }
}
