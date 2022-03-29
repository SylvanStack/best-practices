package com.yuanstack.bp.core.design.behavior.observer.myenvntbus;

import com.google.common.base.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: hansiyuan
 * @date: 2022/3/29 5:56 PM
 */
public class ObserverAction {
    private Object target;
    private Method method;
    public ObserverAction(Object target, Method method){
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        this.method.setAccessible(true);
    }
    public void execute(Object event){ // event是method方法的参数
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
