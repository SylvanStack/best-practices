package com.yuanstack.bp.springsource.introduction.v3_reflect.factory;

import com.yuanstack.bp.springsource.introduction.v3_reflect.dao.DemoDaoV3;
import com.yuanstack.bp.springsource.introduction.v3_reflect.service.DemoServiceV3;

/**
 * @author hansiyuan
 * @date 2022年03月29日 22:23
 */
public class BeanFactoryV3 {

    public static DemoServiceV3 getDemoService() {
        try {
            return (DemoServiceV3) Class.forName("com.yuanstack.bp.springsource.introduction.v3_reflect.service.impl.DemoServiceV3Impl")
                    .newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DemoService instantiation error, cause: " + e.getMessage());
        }
    }

    public static DemoDaoV3 getDemoDao() {
        try {
            return (DemoDaoV3) Class.forName("com.yuanstack.bp.springsource.introduction.v3_reflect.dao.impl.DemoDaoV3Impl").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DemoDao instantiation error, cause: " + e.getMessage());
        }
    }

}
