package com.yuanstack.bp.core.design.behavior.observer.register;

/**
 * @description: 通知观察者
 * @author: hansiyuan
 * @date: 2022/3/29 4:36 PM
 */
public class RegNotificationObserver implements RegObserver{

    // 依赖注入
    private NotificationService notificationService = new NotificationService();

    @Override
    public void handleRegSuccess(long userId){
        notificationService.sendInboxMessage(userId, "Welcome...");
    }
}
