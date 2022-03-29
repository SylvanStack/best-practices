package com.yuanstack.bp.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author hansiyuan
 */
@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @GetMapping("/1.0")
    public String hello() {
        return "hello";
    }
}
