package com.yuanstack.bp.core.advance.concurrent.thread;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:03
 */
public class Runner1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner1运行状态——————————" + i);
        }
    }
}
