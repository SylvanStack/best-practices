package com.yuanstack.bp.core.design.behavior.strategy.helloworld;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 策略的创建
 * @author: hansiyuan
 * @date: 2022/3/15 10:09 AM
 */
public class StrategyFactoryV2 {
    private static final Map<String, StrategyExample> strategies = new HashMap<>();
    static {
        strategies.put("A", new ConcreteStrategyExampleA());
        strategies.put("B", new ConcreteStrategyExampleB());
    }
    public static StrategyExample getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }
}
