package com.yuanstack.bp.core.design.behavior.strategy.order;

/**
 * @description: 待重构的订单服务
 * @author: hansiyuan
 * @date: 2022/3/30 4:23 PM
 */
public class OriginOrderService {
    public double discount(StrategyOrder order){
        double discount = 0.0;
        StrategyOrderType type = order.getType();
        // 普通订单
        if (type.equals(StrategyOrderType.NORMAL)) {
            //...省略折扣计算算法代码
            // 团购订单
        } else if (type.equals(StrategyOrderType.GROUPON)) {
            //...省略折扣计算算法代码
        } else if (type.equals(StrategyOrderType.PROMOTION)) { // 促销订单
            //...省略折扣计算算法代码
        }
        return discount;
    }
}
