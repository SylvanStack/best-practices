package com.yuanstack.bp.spring.helloworld;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author hansiyuan
 * @date 2022年04月01日 22:01
 */
public class DemoMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        long s = System.currentTimeMillis();
        System.out.println("   *****====> " + s + " " + invocation.getMethod().getName());
        Object result = invocation.proceed();
        System.out.println("   *****====> " + (System.currentTimeMillis() - s) + " ms");
        return result;
    }

}
