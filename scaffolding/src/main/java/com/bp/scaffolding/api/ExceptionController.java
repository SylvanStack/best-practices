package com.bp.scaffolding.api;

import com.bp.scaffolding.common.base.ResponseDTO;
import com.bp.scaffolding.service.ExceptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 异常响应Controller
 * @author: hansiyuan
 * @date: 2022/3/4 3:01 PM
 */
@RestController
@RequestMapping(value = "/api/exception")
public class ExceptionController {

    @Resource
    private ExceptionService exceptionService;

    @GetMapping(value = "/error1")
    public ResponseDTO error1() {
        exceptionService.systemBizError();
        return ResponseDTO.success();
    }

    @GetMapping(value = "/error2")
    public ResponseDTO error2(Integer number) {
        exceptionService.userBizError(number);
        return ResponseDTO.success();
    }
}
