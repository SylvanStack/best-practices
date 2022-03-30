package com.yuanstack.bp.core.design.behavior.observer.register;

import com.yuanstack.bp.core.design.behavior.observer.myenvntbus.MyEventBusMessage;

/**
 * @description: 用户服务
 * @author: hansiyuan
 * @date: 2022/3/29 4:28 PM
 */
public class UserService {
    public Long register(String telephone, String password) {
        // 处理逻辑
        return 1L;
    }

    public MyEventBusMessage register() {
        // 处理逻辑
        return new MyEventBusMessage();
    }
}
