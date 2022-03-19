package com.bp.scaffolding.annotation;

import java.lang.annotation.*;

/**
 * @description: 视图跳转注解
 * @author: hansiyuan
 * @date: 2022/3/4 3:23 PM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ModelView {

}
