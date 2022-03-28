package com.bp.dubbo.demo.service;

import com.bp.dubbo.demo.base.OrderDTO;
import com.bp.dubbo.demo.base.ResponseDTO;

/**
 * @description: 举例：同步调用
 * @author: hansiyuan
 * @date: 2021/11/17 4:11 下午
 */
public interface ExampleService {

    /**
     * 字符串返回值
     *
     * @param name 姓名
     * @return 字符串
     */
    String sayHello(String name);

    /**
     * 范型
     *
     * @param orderDTO 订单DTO
     * @return DTO
     */
    ResponseDTO<String> testGeneric(OrderDTO orderDTO);
}
