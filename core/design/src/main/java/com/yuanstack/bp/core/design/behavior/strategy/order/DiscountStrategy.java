package com.yuanstack.bp.core.design.behavior.strategy.order;

/**
 * @description: 策略的定义
 * @author: hansiyuan
 * @date: 2022/4/1 10:35 AM
 */
public interface DiscountStrategy {
    /**
     * 调用折扣算法
     *
     * @param order 订单
     * @return 折扣结果
     */
    double calDiscount(StrategyOrder order);
}
