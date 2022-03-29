package com.yuanstack.bp.springsource.introduction.v2_factory.dao.impl;

import com.yuanstack.bp.springsource.introduction.v2_factory.dao.DemoDaoV2;

import java.util.Arrays;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:12
 */
public class DemoOracleV2Dao implements DemoDaoV2 {

    @Override
    public List<String> findAll() {
        // jdbc operations ......
        System.out.println("DemoOracleV2Dao findAll run ......");
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
