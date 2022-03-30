package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import com.google.common.eventbus.Subscribe;
import com.yuanstack.bp.core.design.behavior.observer.register.PromotionService;

/**
 * @description:
 * @author: hansiyuan
 * @date: 2022/3/29 6:34 PM
 */
public class CustomRegPromotionObserver {
    // 依赖注入
    private PromotionService promotionService = new PromotionService();

    @CustomSubscribe
    public void handleRegSuccess(Long userId){
        promotionService.issueNewUserExperienceCash(userId);
    }
}
