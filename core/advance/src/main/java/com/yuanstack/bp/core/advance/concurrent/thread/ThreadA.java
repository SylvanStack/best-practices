package com.yuanstack.bp.core.advance.concurrent.thread;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:04
 */
public class ThreadA extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}
