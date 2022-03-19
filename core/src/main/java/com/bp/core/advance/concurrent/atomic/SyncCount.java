package com.bp.core.advance.concurrent.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:08
 */
public class SyncCount {

    private int num = 0;

    private Lock lock = new ReentrantLock(true);

    public int add() {
        try {
            lock.lock();
            return num++;
        } finally {
            lock.unlock();
        }
    }

    public int getNum() {
        return num;
    }
}
