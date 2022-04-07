package com.yuanstack.bp.springboot.common.errors.core.dao.impl;

import com.yuanstack.bp.springboot.common.errors.core.dao.BpDataSource;
import org.springframework.stereotype.Repository;

/**
 * @description: mysql
 * @author: hansiyuan
 * @date: 2022/4/6 4:53 PM
 */
@Repository
public class MysqlBpDataSourceImpl implements BpDataSource {
    @Override
    public void getInfo() {
        System.out.println("mysql");
    }
}
