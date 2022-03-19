package com.bp.core.advance.concurrent.atomic;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:08
 */
public class AtomicMain {

    public static void main(String[] args) {
        final SyncCount count = new SyncCount();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        count.add();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("num=" + count.getNum());
    }

}
