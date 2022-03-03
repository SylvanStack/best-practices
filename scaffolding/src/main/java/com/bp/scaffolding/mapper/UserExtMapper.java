package com.bp.scaffolding.mapper;

import com.bp.scaffolding.domain.dto.UserRequestDTO;
import com.bp.scaffolding.domain.model.User;

/**
 * @description: 用户扩展Mapper
 * @author: hansiyuan
 * @date: 2022/3/2 6:42 PM
 */
public interface UserExtMapper {
    /**
     * 根据id查询用户信息
     *
     * @param userRequestDTO 用户请求DTO
     * @return 用户信息
     */
    User queryUserById(UserRequestDTO userRequestDTO);
}
