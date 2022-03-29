package com.yuanstack.bp.core.design.behavior.observer.register;

/**
 * @description: 邮件通知
 * @author: hansiyuan
 * @date: 2022/3/29 4:37 PM
 */
public class NotificationService {
    public void sendInboxMessage(long userId, String s) {
        // 处理逻辑
        System.out.println("注册后执行通知（短信、Email、支付宝消息）逻辑...");
    }
}
