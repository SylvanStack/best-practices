package com.yuanstack.bp.core.design.behavior.observer.helloworld;

/**
 * @description: 观察者（客户端）
 * @author: hansiyuan
 * @date: 2022/3/29 4:04 PM
 */
public interface Observer {
    /**
     * 更新消息
     *
     * @param message 消息
     */
    void update(Message message);
}
