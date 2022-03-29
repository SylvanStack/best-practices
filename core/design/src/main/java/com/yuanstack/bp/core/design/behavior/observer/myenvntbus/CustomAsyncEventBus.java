package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import java.util.concurrent.Executor;

/**
 * @description:
 * @author: hansiyuan
 * @date: 2022/3/29 6:00 PM
 */
public class CustomAsyncEventBus extends CustomEventBus {
    public CustomAsyncEventBus(Executor executor) {
        super(executor);
    }
}
