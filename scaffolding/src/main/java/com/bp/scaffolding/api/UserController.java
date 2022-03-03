package com.bp.scaffolding.api;

import com.bp.scaffolding.domain.base.AjaxResponse;
import com.bp.scaffolding.domain.dto.UserDTO;
import com.bp.scaffolding.domain.dto.UserRequestDTO;
import com.bp.scaffolding.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 用户
 * @author: hansiyuan
 * @date: 2022/2/28 6:25 PM
 */
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "根据用户id获取用户信息", notes = "获取用户信息", tags = "User", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "UserRequestDTO", value = "用户请求DTO", required = true, dataType = "Object"),
    })
    @GetMapping("/getUserById/1.0")
    public AjaxResponse getUserById(UserRequestDTO userRequestDTO) {
        UserDTO userDTO = userService.getUserById(userRequestDTO);
        return AjaxResponse.success(userDTO);
    }
}
