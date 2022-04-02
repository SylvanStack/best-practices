package com.yuanstack.bp.middleware.dbrouter.annotation;

import java.lang.annotation.*;

/**
 * @description: 路由注解
 * @author: hansiyuan
 * @date: 2022/4/2 11:52 AM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouter {

    /**
     * 分库分表字段
     */
    String key() default "";

}

