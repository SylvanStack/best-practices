package com.yuanstack.bp.common.exception.modelview;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hansiyuan
 * @date 2022年03月27日 23:42
 */
@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    //设置切入点：这里直接拦截被@ModelView注解的方法
    @Pointcut("@annotation(com.yuanstack.bp.common.exception.modelview.ModelView)")
    public void pointcut() {
    }

    /**
     * 当有ModelView的注解的方法抛出异常的时候，做如下的处理
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowable(Throwable e) {
        throw ModelViewException.transfer(e);
    }
}
