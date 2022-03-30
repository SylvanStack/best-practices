package com.yuanstack.bp.core.design.behavior.observer.eventbus;

import com.google.common.eventbus.Subscribe;
import com.yuanstack.bp.core.design.behavior.observer.register.NotificationService;

/**
 * @description:
 * @author: hansiyuan
 * @date: 2022/3/29 5:06 PM
 */
public class GuavaRegNotificationObserver {
    private NotificationService notificationService = new NotificationService();

    @Subscribe
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "...");
    }
}
