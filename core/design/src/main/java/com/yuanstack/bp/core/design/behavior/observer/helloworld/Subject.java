package com.yuanstack.bp.core.design.behavior.observer.helloworld;

/**
 * @description: 被观察者（服务端）
 * 在对象之间定义一个一对多的依赖，当一个对象状态改变的时候，所有依赖的对象都会自动收到通知。
 * Subject-Observer、Publisher-Subscriber、Producer-Consumer、
 * EventEmitter-EventListener、Dispatcher-Listener
 * @author: hansiyuan
 * @date: 2022/3/29 4:06 PM
 */
public interface Subject {
    /**
     * 注册观察者客户端
     *
     * @param observer 观察者客户端
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者客户端
     *
     * @param observer 观察者客户端
     */
    void removeObserver(Observer observer);

    /**
     * 消息通知
     *
     * @param message 消息
     */
    void notifyObservers(Message message);
}
