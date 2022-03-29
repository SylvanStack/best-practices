package com.yuanstack.bp.core.advance.jdk8.optional;

import lombok.Builder;
import lombok.Data;

/**
 * @description: 用户类
 * @author: hansiyuan
 * @date: 2022/3/28 6:57 PM
 */
@Data
@Builder
public class User {
    private Long id;
    private String name;
}