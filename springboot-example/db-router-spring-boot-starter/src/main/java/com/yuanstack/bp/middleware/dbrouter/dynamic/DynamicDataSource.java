package com.yuanstack.bp.middleware.dbrouter.dynamic;

import com.yuanstack.bp.middleware.dbrouter.DBContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @description: 动态数据源
 * @author: hansiyuan
 * @date: 2022/4/2 11:54 AM
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return "db" + DBContextHolder.getDBKey();
    }

}

