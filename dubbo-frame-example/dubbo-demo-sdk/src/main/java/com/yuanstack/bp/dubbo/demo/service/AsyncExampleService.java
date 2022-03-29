package com.yuanstack.bp.dubbo.demo.service;

import java.util.concurrent.CompletableFuture;

/**
 * @description: 举例：基于定义CompletableFuture签名的接口如何实现异步执行
 * @author: hansiyuan
 * @date: 2021/11/17 4:11 下午
 */
public interface AsyncExampleService {

    CompletableFuture<String> sayHello(String name);
}
