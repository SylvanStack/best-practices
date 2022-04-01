package com.yuanstack.bp.core.design.behavior.strategy.order;

/**
 * @description: 正常折扣策略
 * @author: hansiyuan
 * @date: 2022/4/1 10:38 AM
 */
public class NormalDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(StrategyOrder order) {
        return 0;
    }
}
