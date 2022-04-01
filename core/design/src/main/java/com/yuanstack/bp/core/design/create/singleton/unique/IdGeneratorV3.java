package com.yuanstack.bp.core.design.create.singleton.unique;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 静态内部类
 *
 * @author hansiyuan
 * @date 2022年03月14日 23:15
 */
public class IdGeneratorV3 {
    private AtomicLong id = new AtomicLong(0);

    private IdGeneratorV3() {
    }

    private static class SingletonHolder {
        private static final IdGeneratorV3 instance = new IdGeneratorV3();
    }

    public static IdGeneratorV3 getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGeneratorV3.getInstance().getId());
    }
}
