package com.yuanstack.bp.scaffolding.api;

import com.yuanstack.bp.scaffolding.common.base.ResponseDTO;
import com.yuanstack.bp.scaffolding.common.dto.UserDTO;
import com.yuanstack.bp.scaffolding.common.dto.UserRequestDTO;
import com.yuanstack.bp.scaffolding.service.UserService;
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
    public ResponseDTO getUserById(UserRequestDTO userRequestDTO) {
        UserDTO userDTO = userService.getUserById(userRequestDTO);
        return ResponseDTO.success(userDTO);
    }
}
