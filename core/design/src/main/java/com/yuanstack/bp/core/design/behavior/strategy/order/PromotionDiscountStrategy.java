package com.yuanstack.bp.core.design.behavior.strategy.order;

/**
 * @description: 折扣策略
 * @author: hansiyuan
 * @date: 2022/4/1 10:40 AM
 */
public class PromotionDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(StrategyOrder order) {
        return 0;
    }
}
