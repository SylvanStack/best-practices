package com.yuanstack.bp.core.design.behavior.observer.helloworld;

/**
 * @description: TODO(这里用一句话描述这个类的作用)
 * @author: hansiyuan
 * @date: 2022/3/29 4:08 PM
 */
public class ObserverMain {
    public static void main(String[] args){
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message());
    }
}
