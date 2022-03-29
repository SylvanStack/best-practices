package com.yuanstack.bp.core.design.behavior.observer.eventbus;

import com.yuanstack.bp.core.design.behavior.observer.register.RegNotificationObserver;
import com.yuanstack.bp.core.design.behavior.observer.register.RegObserver;
import com.yuanstack.bp.core.design.behavior.observer.register.RegPromotionObserver;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class AsyncRegisterCodeExampleTest {

    @Test
    void register() {
        Executor executor = Executors.newFixedThreadPool(20);
        AsyncRegisterCodeExample example = new AsyncRegisterCodeExample(executor);
        List<RegObserver> observers = new ArrayList<>();
        observers.add(new RegNotificationObserver());
        observers.add(new RegPromotionObserver());
        example.setRegObservers(observers);
        example.register("1111111", "aaaa");
    }
}