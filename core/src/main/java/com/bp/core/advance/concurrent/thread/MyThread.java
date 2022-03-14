package com.bp.core.advance.concurrent.thread;

/**
 * @description: ThreadDemo
 * @author: hansiyuan
 * @date: 2022/3/14 10:44 AM
 */
public class MyThread {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("异步线程")).start();
    }
}
