package com.yuanstack.bp.core.design.behavior.strategy.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 策略模式demo需要的订单类
 * @author: hansiyuan
 * @date: 2022/3/30 4:24 PM
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StrategyOrder {
    private StrategyOrderType type;
}
