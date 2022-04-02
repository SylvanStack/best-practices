package com.yuanstack.bp.middleware.dbrouter.annotation;

import java.lang.annotation.*;

/**
 * @description: 路由策略，分表标记
 * @author: hansiyuan
 * @date: 2022/4/2 11:53 AM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouterStrategy {

    boolean splitTable() default false;

}

