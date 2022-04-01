package com.yuanstack.bp.spring.helloworld.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:12
 */
@Aspect
public class Aop2 {

    @Pointcut(value = "execution(* com.yuanstack.bp.spring.helloworld.aop.Klass.*dong(..))")
    public void point() {

    }

    @Before(value = "point()")
    public void before() {
        System.out.println("========>begin klass dong... //2");
    }

    @AfterReturning(value = "point()")
    public void after() {
        System.out.println("========>after klass dong... //4");
    }

    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("========>around begin klass dong //1");
        joinPoint.proceed();
        System.out.println("========>around after klass dong //3");

    }
}