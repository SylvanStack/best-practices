package com.yuanstack.bp.core.design.behavior.observer.register;

/**
 * @description: 注册观察者
 * @author: hansiyuan
 * @date: 2022/3/29 4:34 PM
 */
public interface RegObserver{
    /**
     * 注册成功后的处理
     * @param userId 用户id
     */
    void handleRegSuccess(long userId);
}
