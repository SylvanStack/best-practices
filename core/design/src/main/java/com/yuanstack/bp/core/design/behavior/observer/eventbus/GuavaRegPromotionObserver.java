package com.yuanstack.bp.core.design.behavior.observer.eventbus;

import com.google.common.eventbus.Subscribe;
import com.yuanstack.bp.core.design.behavior.observer.register.PromotionService;

/**
 * @description:
 * @author: hansiyuan
 * @date: 2022/3/29 5:03 PM
 */
public class GuavaRegPromotionObserver{
    // 依赖注入
    private PromotionService promotionService = new PromotionService();

    @Subscribe
    public void handleRegSuccess(Long userId){
        promotionService.issueNewUserExperienceCash(userId);
    }
}
