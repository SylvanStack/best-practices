package com.yuanstack.bp.core.design.create.singleton.multiple;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 多例日志（仅为举例）
 * @author: hansiyuan
 * @date: 2022/4/1 6:11 PM
 */
public class MultipleLogger {
    private static final ConcurrentHashMap<String, MultipleLogger> instances = new ConcurrentHashMap<>();

    private MultipleLogger() {
    }

    public static MultipleLogger getInstance(String loggerName) {
        instances.putIfAbsent(loggerName, new MultipleLogger());
        return instances.get(loggerName);
    }

    public void log() {
        //...
    }

    public static void main(String[] args) {
        //l1==l2, l1!=l3
        MultipleLogger l1 = MultipleLogger.getInstance("User.class");
        MultipleLogger l2 = MultipleLogger.getInstance("User.class");
        MultipleLogger l3 = MultipleLogger.getInstance("Order.class");
    }
}
