package com.yuanstack.bp.springsource.introduction.v5_cached.service.impl;

import com.yuanstack.bp.springsource.introduction.v5_cached.dao.DemoDaoV5;
import com.yuanstack.bp.springsource.introduction.v5_cached.factory.BeanFactoryV5;
import com.yuanstack.bp.springsource.introduction.v5_cached.service.DemoServiceV5;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 23:05
 */
public class DemoServiceV5Impl implements DemoServiceV5 {

    DemoDaoV5 demoDao = (DemoDaoV5) BeanFactoryV5.getBean("demoDaoV5");

    public DemoServiceV5Impl() {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactoryV5.getBean("demoDaoV5"));
        }
    }

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
