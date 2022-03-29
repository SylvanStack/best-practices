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

class GuavaEventBusRegisterCodeExampleTest {

    @Test
    void register() throws InterruptedException {
        GuavaEventBusRegisterCodeExample example = new GuavaEventBusRegisterCodeExample();
        List<Object> observers = new ArrayList<>();
        observers.add(new GuavaRegNotificationObserver());
        observers.add(new GuavaRegPromotionObserver());
        example.setRegObservers(observers);
        example.register("1111111", "aaaa");
        Thread.sleep(1000L);
    }
}