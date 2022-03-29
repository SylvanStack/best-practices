package com.yuanstack.bp.springsource.introduction.v2_factory.factory;

import com.yuanstack.bp.springsource.introduction.v2_factory.dao.DemoDaoV2;
import com.yuanstack.bp.springsource.introduction.v2_factory.dao.impl.DemoMySQLV2Dao;
import com.yuanstack.bp.springsource.introduction.v2_factory.service.DemoServiceV2;
import com.yuanstack.bp.springsource.introduction.v2_factory.service.impl.DemoServiceV2Impl;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:13
 */
public class BeanFactoryV2 {

    public static DemoServiceV2 getDemoService() {
        return new DemoServiceV2Impl();
    }

    public static DemoDaoV2 getDemoDao() {
//        return new DemoDaoImpl();
        return new DemoMySQLV2Dao();
    }

}
