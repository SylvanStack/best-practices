package com.bp.scaffolding.service.impl;

import com.bp.scaffolding.common.dto.UserDTO;
import com.bp.scaffolding.common.dto.UserRequestDTO;
import com.bp.scaffolding.common.model.User;
import com.bp.scaffolding.mapper.UserExtMapper;
import com.bp.scaffolding.mapper.UserMapper;
import com.bp.scaffolding.service.UserService;
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
