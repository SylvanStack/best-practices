package com.yuanstack.bp.core.design.behavior.strategy.order;

/**
 * @description: 团体折扣策略
 * @author: hansiyuan
 * @date: 2022/4/1 10:39 AM
 */
public class GrouponDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(StrategyOrder order) {
        return 0;
    }
}
