package com.bp.core.advance.jvm.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 反射使用
 * @author: hansiyuan
 * @date: 2022/3/2 11:26 AM
 */
public class ReflectExample {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> cls = Class.forName("com.bp.core.advance.jvm.reflect.AdTv");
        Object adTv = cls.getDeclaredConstructor().newInstance();
        Method show = cls.getMethod("show");
        show.invoke(adTv);
    }
}
