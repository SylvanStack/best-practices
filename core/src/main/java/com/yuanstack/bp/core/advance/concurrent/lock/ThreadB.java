package com.yuanstack.bp.core.advance.concurrent.lock;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:11
 */
public class ThreadB extends Thread {
    private Count3 count3;

    public ThreadB(Count3 count3) {
        this.count3 = count3;
    }

    public void run() {
        count3.lockMethod();
    }

}
