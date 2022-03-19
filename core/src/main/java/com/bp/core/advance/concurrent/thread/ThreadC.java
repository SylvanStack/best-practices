package com.bp.core.advance.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:05
 */
public class ThreadC implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("这是线程C");
        return "线程C";
    }
}
