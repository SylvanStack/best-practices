package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import com.google.common.eventbus.Subscribe;
import com.yuanstack.bp.core.design.behavior.observer.register.NotificationService;

/**
 * @description:
 * @author: hansiyuan
 * @date: 2022/3/29 6:15 PM
 */
public class CustomRegNotificationObserver {
    private NotificationService notificationService = new NotificationService();

    @CustomSubscribe
    public void handleRegSuccess(long userId){
        notificationService.sendInboxMessage(userId, "...");
    }
}
