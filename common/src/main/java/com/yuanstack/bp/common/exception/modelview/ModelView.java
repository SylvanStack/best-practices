package com.yuanstack.bp.common.exception.modelview;

import java.lang.annotation.*;

/**
 * @author hansiyuan
 * @date 2022年03月27日 23:42
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})//只能在方法上使用此注解
public @interface ModelView {

}
