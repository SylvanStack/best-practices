package com.bp.core.advance.concurrent.lock;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:11
 */
public class ThreadA extends Thread {
    private Count3 count3;

    public ThreadA(Count3 count3) {
        this.count3 = count3;
    }

    public void run() {
        count3.add();
    }

}
