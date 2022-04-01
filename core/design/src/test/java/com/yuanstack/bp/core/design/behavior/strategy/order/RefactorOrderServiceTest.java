package com.yuanstack.bp.core.design.behavior.strategy.order;

import org.junit.jupiter.api.Test;

class RefactorOrderServiceTest {

    @Test
    void discount() {
        RefactorOrderService revertOrderService = new RefactorOrderService();
        revertOrderService.discount(new StrategyOrder(StrategyOrderType.NORMAL));
    }
}