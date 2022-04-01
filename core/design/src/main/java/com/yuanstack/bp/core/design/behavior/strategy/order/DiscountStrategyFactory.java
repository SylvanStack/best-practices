package com.yuanstack.bp.core.design.behavior.strategy.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 订单策略工厂（策略的创建）
 * @author: hansiyuan
 * @date: 2022/4/1 10:36 AM
 */
public class DiscountStrategyFactory{
    private static final Map<StrategyOrderType, DiscountStrategy> strategies = new HashMap<>();
    static {
        strategies.put(StrategyOrderType.NORMAL, new NormalDiscountStrategy());
        strategies.put(StrategyOrderType.GROUPON, new GrouponDiscountStrategy());
        strategies.put(StrategyOrderType.PROMOTION, new PromotionDiscountStrategy());
    }
    public static DiscountStrategy getDiscountStrategy(StrategyOrderType type){
        return strategies.get(type);
    }
}
