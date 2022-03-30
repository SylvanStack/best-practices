package com.yuanstack.bp.core.design.behavior.strategy.order;

import lombok.Data;

/**
 * @description: 策略模式demo需要的订单类
 * @author: hansiyuan
 * @date: 2022/3/30 4:24 PM
 */
@Data
public class StrategyOrder {
    private StrategyOrderType type;
}
