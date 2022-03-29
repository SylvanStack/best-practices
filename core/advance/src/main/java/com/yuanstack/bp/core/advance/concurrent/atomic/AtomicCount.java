package com.yuanstack.bp.core.advance.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hansiyuan
 * @date 2022年03月19日 18:08
 */
public class AtomicCount {

    private AtomicInteger num = new AtomicInteger();

    public int add() {
        return num.getAndIncrement();
    }

    public int getNum() {
        return num.get();
    }
}
