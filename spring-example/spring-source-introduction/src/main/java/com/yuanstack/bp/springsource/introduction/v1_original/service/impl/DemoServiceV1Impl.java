package com.yuanstack.bp.springsource.introduction.v1_original.service.impl;

import com.yuanstack.bp.springsource.introduction.v1_original.dao.DemoDaoV1;
import com.yuanstack.bp.springsource.introduction.v1_original.dao.impl.DemoDaoV1Impl;
import com.yuanstack.bp.springsource.introduction.v1_original.service.DemoServiceV1;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:06
 */
public class DemoServiceV1Impl implements DemoServiceV1 {

    DemoDaoV1 demoDao = new DemoDaoV1Impl();

    @Override
    public List<String> findAll() {
        return demoDao.findAll();
    }
}
