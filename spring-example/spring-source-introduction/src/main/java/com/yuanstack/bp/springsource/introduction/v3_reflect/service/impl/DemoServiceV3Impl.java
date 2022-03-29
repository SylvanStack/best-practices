package com.yuanstack.bp.springsource.introduction.v3_reflect.service.impl;

import com.yuanstack.bp.springsource.introduction.v3_reflect.dao.DemoDaoV3;
import com.yuanstack.bp.springsource.introduction.v3_reflect.factory.BeanFactoryV3;
import com.yuanstack.bp.springsource.introduction.v3_reflect.service.DemoServiceV3;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:21
 */
public class DemoServiceV3Impl implements DemoServiceV3 {

    DemoDaoV3 demoDao = BeanFactoryV3.getDemoDao();

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
