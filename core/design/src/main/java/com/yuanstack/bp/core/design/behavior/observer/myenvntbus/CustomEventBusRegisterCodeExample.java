package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.yuanstack.bp.core.design.behavior.observer.register.UserService;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: hansiyuan
 * @date: 2022/3/29 6:37 PM
 */
public class CustomEventBusRegisterCodeExample {
    // 依赖注入
    private UserService userService = new UserService();
    private CustomEventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public CustomEventBusRegisterCodeExample() {
        // 同步阻塞模式
        //eventBus = new EventBus();
        // 异步非阻塞模式
        Executor executor = Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE);
        eventBus = new CustomAsyncEventBus(executor);
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        Long userId = userService.register(telephone, password);
        System.out.println("注册逻辑...");
        eventBus.post(userId);
        return userId;
    }
}
