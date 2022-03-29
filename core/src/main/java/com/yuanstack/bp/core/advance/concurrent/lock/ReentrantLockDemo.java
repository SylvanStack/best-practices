package com.yuanstack.bp.core.advance.concurrent.lock;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:12
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        final Count count = new Count();

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread() {
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}
