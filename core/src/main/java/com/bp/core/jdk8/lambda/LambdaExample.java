package com.bp.core.jdk8.lambda;

/**
 * @description: lambda例子
 * @author: hansiyuan
 * @date: 2021/10/31 1:48 下午
 */
public class LambdaExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println(1));
        thread.start();
    }
}
