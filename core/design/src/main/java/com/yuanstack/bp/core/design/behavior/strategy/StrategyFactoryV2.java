package com.yuanstack.bp.core.design.behavior.strategy;

/**
 * @description: 策略使用V2
 * @author: hansiyuan
 * @date: 2022/3/15 10:11 AM
 */
public class StrategyFactoryV2 {
    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        if ("A".equals(type)) {
            return new ConcreteStrategyA();
        } else if ("B".equals(type)) {
            return new ConcreteStrategyB();
        }
        return null;
    }
}
