package com.yuanstack.bp.core.advance.concurrent.sync;

/**
 * @description: 安全的计算
 * @author: hansiyuan
 * @date: 2022/3/29 10:36 AM
 */
public class SafeCalc {
    long value = 0L;

    synchronized long get() {
        return value;
    }

    synchronized void addOne() {
        value += 1;
    }
}
