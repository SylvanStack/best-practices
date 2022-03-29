package com.yuanstack.bp.springsource.introduction.v1_original.dao.impl;

import com.yuanstack.bp.springsource.introduction.v1_original.dao.DemoDaoV1;

import java.util.Arrays;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:07
 */
public class DemoDaoV1Impl implements DemoDaoV1 {

    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
