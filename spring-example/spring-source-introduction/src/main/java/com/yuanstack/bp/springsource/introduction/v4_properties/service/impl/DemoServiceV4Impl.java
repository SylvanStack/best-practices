package com.yuanstack.bp.springsource.introduction.v4_properties.service.impl;

import com.yuanstack.bp.springsource.introduction.v4_properties.dao.DemoDaoV4;
import com.yuanstack.bp.springsource.introduction.v4_properties.factory.BeanFactoryV4;
import com.yuanstack.bp.springsource.introduction.v4_properties.service.DemoServiceV4;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 23:05
 */
public class DemoServiceV4Impl implements DemoServiceV4 {

    DemoDaoV4 demoDao = (DemoDaoV4) BeanFactoryV4.getBean("demoDaoV4");

    public DemoServiceV4Impl() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactoryV4.getBean("demoDaoV4"));
        }
    }

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
