package com.yuanstack.bp.springboot.common.errors.core.dao.impl;

import com.yuanstack.bp.springboot.common.errors.core.dao.BpDataSource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @description: Jdbc
 * @author: hansiyuan
 * @date: 2022/4/6 4:09 PM
 */
@Primary
@Repository
public class JdbcBpDataSourceImpl implements BpDataSource {
    @Override
    public void getInfo() {
        System.out.println("jdbc");
    }
}
