package com.bp.dubbo.demo.consumer.api;

import com.bp.dubbo.demo.service.ExampleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @description: 同步调用Controller
 * @author: hansiyuan
 * @date: 2021/11/18 10:56 上午
 */
@Controller
@RequestMapping("/api/example")
public class ExampleController {

    @Resource
    private ExampleService exampleService;

    @GetMapping("/hello/1.0")
    @ResponseBody
    private String sayHello(String name) {
        return exampleService.sayHello(name);
    }
}
