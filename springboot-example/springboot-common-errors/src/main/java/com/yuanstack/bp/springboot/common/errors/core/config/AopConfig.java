package com.yuanstack.bp.springboot.common.errors.core.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * @description: 切面配置
 * @author: hansiyuan
 * @date: 2022/4/6 6:13 PM
 */
@Aspect
@Service
@Slf4j
public class AopConfig {
    @Around("execution(* com.yuanstack.bp.springboot.common.errors.core.service.ElectricService.pay()) ")
    public void recordPayPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Pay method time cost（ms）: " + (end - start));
    }
}
