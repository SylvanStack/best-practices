package com.yuanstack.bp.dubbo.demo.provider.service;

import com.alibaba.fastjson.JSON;
import com.yuanstack.bp.dubbo.demo.base.OrderDTO;
import com.yuanstack.bp.dubbo.demo.base.ResponseDTO;
import com.yuanstack.bp.dubbo.demo.service.ExampleService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;

/**
 * @description: 举例
 * @author: hansiyuan
 * @date: 2021/11/18 9:56 上午
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public String sayHello(String name) {
        try {
            // 休眠1s
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取调用方在上下文对象中附加的company变量的值，如果调用方在调用前没进行设置，则返回null
        return "Hello " + name + "  " + RpcContext.getContext().getAttachment("company");
    }

    @Override
    public ResponseDTO<String> testGeneric(OrderDTO orderDTO) {
        ResponseDTO<String> result = new ResponseDTO<String>();
        result.setMessage("成功");
        result.setStatusNum(200);
        result.setIsOk(true);
        // 传入的对象转换为字符串后返回
        result.setData(JSON.toJSONString(orderDTO));
        return result;
    }
}
