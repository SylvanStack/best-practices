package com.yuanstack.bp.core.advance.concurrent.lock;


/**
 * @author hansiyuan
 * @date 2022年03月19日 18:10
 */
public class LockMain {

    public static void main(String[] args) {
        Count3 count3 = new Count3();
        ThreadA threadA = new ThreadA(count3);
        threadA.setName("线程A");
        threadA.start();

        ThreadB threadB = new ThreadB(count3);
        threadB.setName("线程B");
        threadB.start();

    }

}
