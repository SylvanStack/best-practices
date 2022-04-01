package com.yuanstack.bp.core.design.behavior.strategy.order;

/**
 * @description: 重构订单服务（策略的使用）
 * @author: hansiyuan
 * @date: 2022/4/1 10:37 AM
 */
public class RefactorOrderService {
    /**
     * 计算折扣
     *
     * @param order 订单
     * @return 折扣价
     */
    public double discount(StrategyOrder order) {
        StrategyOrderType type = order.getType();
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type);
        return discountStrategy.calDiscount(order);
    }
}
