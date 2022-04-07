package com.yuanstack.bp.springboot.common.errors.core.controller;

import com.yuanstack.bp.springboot.common.errors.core.service.ElectricService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: HelloWorld
 * @author: hansiyuan
 * @date: 2022/4/6 5:51 PM
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @Resource
    private ElectricService electricService;

    @RequestMapping(path = "charge", method = RequestMethod.GET)
    public void charge() throws Exception {
        electricService.charge();
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
