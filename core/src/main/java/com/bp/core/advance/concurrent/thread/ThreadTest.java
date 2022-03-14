package com.bp.core.advance.concurrent.thread;

/**
 * @description: 多线程的可见性问题
 * @author: hansiyuan
 * @date: 2022/3/14 10:59 AM
 */
public class ThreadTest {
    private long count = 0;

    private synchronized void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadTest test = new ThreadTest();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        System.out.println(test.count);
    }
}
