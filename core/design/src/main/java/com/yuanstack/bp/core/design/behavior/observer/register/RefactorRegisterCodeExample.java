package com.yuanstack.bp.core.design.behavior.observer.register;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 观察者模式重构后代码
 * @author: hansiyuan
 * @date: 2022/3/29 4:38 PM
 */
public class RefactorRegisterCodeExample {
    // 依赖注入
    private UserService userService = new UserService();
    private List<RegObserver> regObservers = new ArrayList<>();

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        System.out.println("注册逻辑...");
        for (RegObserver observer : regObservers) {
            observer.handleRegSuccess(userId);
        }
        return userId;
    }
}
