package com.yuanstack.bp.spring.source.ioc.annotation.dl.v2_bytype.dao.impl;

import com.yuanstack.bp.spring.source.ioc.annotation.dl.v2_bytype.dao.ByTypeDao;

import java.util.Arrays;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月30日 22:11
 */
public class ByTypeDaoImpl implements ByTypeDao {
    @Override
    public List<String> findAll() {
        return Arrays.asList("aaa", "bbb", "ccc");
    }
}
