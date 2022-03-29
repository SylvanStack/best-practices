package com.yuanstack.bp.core.design.behavior.observer.helloworld;

/**
 * @description: 具体观察者二
 * @author: hansiyuan
 * @date: 2022/3/29 4:07 PM
 */
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message){
        // 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo is notified.");
    }
}
