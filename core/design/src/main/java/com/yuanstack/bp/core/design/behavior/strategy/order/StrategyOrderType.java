package com.yuanstack.bp.core.design.behavior.strategy.order;

import lombok.Getter;

/**
 * 策略需要的订单类型枚举类
 *
 * @author hansiyuan
 */
public enum StrategyOrderType {
    GROUPON("GROUPON"),
    PROMOTION("PROMOTION"),
    NORMAL("NORMAL");

    @Getter
    private String type;

    StrategyOrderType(String type) {
        this.type = type;
    }
}
