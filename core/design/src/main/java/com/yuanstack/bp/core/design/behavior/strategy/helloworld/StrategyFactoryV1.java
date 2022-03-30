package com.yuanstack.bp.core.design.behavior.strategy.helloworld;

/**
 * @description: 策略使用V2
 * @author: hansiyuan
 * @date: 2022/3/15 10:11 AM
 */
public class StrategyFactoryV1 {
    public static StrategyExample getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        if ("A".equals(type)) {
            return new ConcreteStrategyExampleA();
        } else if ("B".equals(type)) {
            return new ConcreteStrategyExampleB();
        }
        return null;
    }
}
