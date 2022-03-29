package com.yuanstack.bp.springsource.introduction.v2_factory.dao.impl;


import com.yuanstack.bp.springsource.introduction.v2_factory.dao.DemoDaoV2;

import java.util.Arrays;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:07
 */
public class DemoDaoV2Impl implements DemoDaoV2 {

    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
