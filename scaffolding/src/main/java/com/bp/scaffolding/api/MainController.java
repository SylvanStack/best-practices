package com.bp.scaffolding.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 健康检查
 * @author: hansiyuan
 * @date: 2022/2/28 6:18 PM
 */
@RestController
public class MainController {
    /**
     * 健康检查
     */
    @GetMapping("/checkPreload")
    public String checkPreload() {
        return "success";
    }
}
