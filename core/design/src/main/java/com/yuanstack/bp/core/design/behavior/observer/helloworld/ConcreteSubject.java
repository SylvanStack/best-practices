package com.yuanstack.bp.core.design.behavior.observer.helloworld;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 具体被观察者
 * @author: hansiyuan
 * @date: 2022/3/29 4:06 PM
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
