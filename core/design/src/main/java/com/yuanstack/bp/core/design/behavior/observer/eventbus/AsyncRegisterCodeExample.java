package com.yuanstack.bp.core.design.behavior.observer.eventbus;

import com.yuanstack.bp.core.design.behavior.observer.register.RegObserver;
import com.yuanstack.bp.core.design.behavior.observer.register.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @description: 异步执行
 * @author: hansiyuan
 * @date: 2022/3/29 4:55 PM
 */
public class AsyncRegisterCodeExample {
    // 依赖注入
    private UserService userService = new UserService();
    private List<RegObserver> regObservers = new ArrayList<>();
    private Executor executor;

    public AsyncRegisterCodeExample(Executor executor) {
        this.executor = executor;
    }

    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        System.out.println("注册逻辑...");
        for (RegObserver observer : regObservers) {
            executor.execute(() -> observer.handleRegSuccess(userId));
        }
        return userId;
    }
}
