package com.yuanstack.bp.springboot.common.errors.core.service;

import org.springframework.stereotype.Service;

/**
 * @description: 充电业务逻辑类
 * @author: hansiyuan
 * @date: 2022/4/6 6:12 PM
 */
@Service
public class ElectricService {
    public void charge() throws Exception {
        System.out.println("Electric charging ...");
        pay();
    }

    public void pay() throws Exception {
        System.out.println("Pay with alipay ...");
        Thread.sleep(1000);
    }
}
