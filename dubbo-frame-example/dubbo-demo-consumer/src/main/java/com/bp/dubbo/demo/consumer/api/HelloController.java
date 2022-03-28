package com.bp.dubbo.demo.consumer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试Http请求
 * @author: hansiyuan
 * @date: 2021/11/18 11:26 上午
 */
@RequestMapping("/api/hello")
@RestController
public class HelloController {

    @GetMapping("/1.0")
    public String hello() {
        return "Hello World";
    }

}
