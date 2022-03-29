package com.yuanstack.bp.core.design.behavior.observer.register;

/**
 * @description: 推广观察者
 * @author: hansiyuan
 * @date: 2022/3/29 4:35 PM
 */
public class RegPromotionObserver implements RegObserver {
    // 依赖注入
    private PromotionService promotionService = new PromotionService();

    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
