package com.yuanstack.bp.core.design.behavior.observer.register;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RefactorRegisterCodeExampleTest {
    @Test
    public void register() {
        RefactorRegisterCodeExample registerCodeExample = new RefactorRegisterCodeExample();
        List<RegObserver> observers = new ArrayList<>();
        observers.add(new RegNotificationObserver());
        observers.add(new RegPromotionObserver());
        registerCodeExample.setRegObservers(observers);
        registerCodeExample.register("1111111", "aaaa");
    }
}