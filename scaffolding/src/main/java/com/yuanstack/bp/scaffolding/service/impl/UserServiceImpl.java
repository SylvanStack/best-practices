package com.yuanstack.bp.scaffolding.service.impl;

import com.yuanstack.bp.scaffolding.common.dto.UserDTO;
import com.yuanstack.bp.scaffolding.common.dto.UserRequestDTO;
import com.yuanstack.bp.scaffolding.common.model.User;
import com.yuanstack.bp.scaffolding.mapper.UserExtMapper;
import com.yuanstack.bp.scaffolding.mapper.UserMapper;
import com.yuanstack.bp.scaffolding.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hansiyuan
 * @since 2022-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserExtMapper userExtMapper;

    @Override
    public UserDTO getUserById(UserRequestDTO userRequestDTO) {
        User user = userExtMapper.queryUserById(userRequestDTO);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }
}
