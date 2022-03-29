package com.yuanstack.bp.scaffolding.handeler;

import com.yuanstack.bp.scaffolding.common.expection.ModelViewException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description: ModelView切面
 * @author: hansiyuan
 * @date: 2022/3/4 3:24 PM
 */
@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    /**
     * 设置切入点：这里直接拦截被@ModelView注解的方法
     */
    @Pointcut("@annotation(com.yuanstack.bp.scaffolding.annotation.ModelView)")
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
