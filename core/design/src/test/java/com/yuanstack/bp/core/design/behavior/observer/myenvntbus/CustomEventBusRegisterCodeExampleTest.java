package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class CustomEventBusRegisterCodeExampleTest {
    CustomEventBusRegisterCodeExample example = new CustomEventBusRegisterCodeExample();

    @Test
    void register() throws InterruptedException {
        List<Object> observers = new ArrayList<>();
        observers.add(new CustomRegNotificationObserver());
        observers.add(new CustomRegPromotionObserver());
        example.setRegObservers(observers);
        example.register("1111111", "aaaa");
        Thread.sleep(1000L);
    }

    @Test
    public void assignableFrom() {
        Long time = 1L;
        Long aa = 1L;
        Class<?> aaa = time.getClass();
        Class<?> bbb = aa.getClass();
        System.out.println(time.getClass().isAssignableFrom(aa.getClass()));
    }
}