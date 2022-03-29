package com.yuanstack.bp.springsource.introduction.v2_factory.service.impl;

import com.yuanstack.bp.springsource.introduction.v2_factory.dao.DemoDaoV2;
import com.yuanstack.bp.springsource.introduction.v2_factory.factory.BeanFactoryV2;
import com.yuanstack.bp.springsource.introduction.v2_factory.service.DemoServiceV2;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:14
 */
public class DemoServiceV2Impl2 implements DemoServiceV2 {

    DemoDaoV2 demoDao = BeanFactoryV2.getDemoDao();

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
