package com.yuanstack.bp.springsource.introduction.v5_cached.dao.impl;

import com.yuanstack.bp.springsource.introduction.v5_cached.dao.DemoDaoV5;

import java.util.Arrays;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 23:07
 */
public class DemoDaoV5Impl implements DemoDaoV5 {

    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
