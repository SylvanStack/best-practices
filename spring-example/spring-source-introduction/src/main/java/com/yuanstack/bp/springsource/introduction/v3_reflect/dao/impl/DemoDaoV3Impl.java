package com.yuanstack.bp.springsource.introduction.v3_reflect.dao.impl;

import com.yuanstack.bp.springsource.introduction.v3_reflect.dao.DemoDaoV3;

import java.util.Arrays;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:22
 */
public class DemoDaoV3Impl implements DemoDaoV3 {
    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
