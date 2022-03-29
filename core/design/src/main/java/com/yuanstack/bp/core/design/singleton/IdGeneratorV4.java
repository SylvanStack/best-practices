package com.yuanstack.bp.core.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hansiyuan
 * @date 2022年03月14日 23:16
 */
public enum IdGeneratorV4 {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(IdGeneratorV4.INSTANCE.getId());
        }
    }
}
