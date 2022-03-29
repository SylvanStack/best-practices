package com.yuanstack.bp.core.design.behavior.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 策略的创建
 * @author: hansiyuan
 * @date: 2022/3/15 10:09 AM
 */
public class StrategyFactory {
    private static final Map<String, Strategy> strategies = new HashMap<>();
    static {
        strategies.put("A", new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }
    public static Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }
}
