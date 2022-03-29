package com.yuanstack.bp.springsource.introduction.v4_properties.dao.impl;

import com.yuanstack.bp.springsource.introduction.v4_properties.dao.DemoDaoV4;

import java.util.Arrays;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 23:07
 */
public class DemoDaoV4Impl implements DemoDaoV4 {

    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
