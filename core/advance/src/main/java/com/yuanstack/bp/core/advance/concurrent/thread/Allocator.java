package com.yuanstack.bp.core.advance.concurrent.thread;

import java.util.List;

/**
 * @description: 资源分配器
 * @author: hansiyuan
 * @date: 2022/3/14 11:51 AM
 */
public class Allocator {
    /**
     * 正在使用的资源
     */
    private List<Object> als;

    /**
     * 一次性申请所有资源
     */
    synchronized void apply(Object from, Object to) {
        // 经典写法
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (Exception ignored) {
            }
        }
        als.add(from);
        als.add(to);
    }

    /**
     * 归还资源
     */
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
