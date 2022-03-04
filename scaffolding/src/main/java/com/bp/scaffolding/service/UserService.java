package com.bp.scaffolding.service;

import com.bp.scaffolding.common.dto.UserDTO;
import com.bp.scaffolding.common.dto.UserRequestDTO;
import com.bp.scaffolding.common.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hansiyuan
 * @since 2022-03-03
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户Id获取用户信息
     * @param userRequestDTO 用户请求DTO
     * @return UserDTO
     */
    UserDTO getUserById(UserRequestDTO userRequestDTO);
}
