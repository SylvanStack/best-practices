package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import org.junit.jupiter.api.Test;

class ObserverRegistryTest {
    ObserverRegistry observerRegistry = new ObserverRegistry();
    @Test
    void register() {
        observerRegistry.register(new CustomRegNotificationObserver());
        observerRegistry.register(new CustomRegNotificationObserver());
    }

    @Test
    void getMatchedObserverActions() {
    }
}