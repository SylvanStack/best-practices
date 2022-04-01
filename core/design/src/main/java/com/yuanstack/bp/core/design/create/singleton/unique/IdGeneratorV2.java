package com.yuanstack.bp.core.design.create.singleton.unique;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 双检锁
 *
 * @author hansiyuan
 * @date 2022年03月14日 23:13
 */
public class IdGeneratorV2 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorV2 instance;

    private IdGeneratorV2() {
    }

    public static IdGeneratorV2 getInstance() {
        if (instance == null) {
            synchronized (IdGeneratorV2.class) {
                if (instance == null) {
                    instance = new IdGeneratorV2();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGeneratorV2.getInstance().getId());
    }
}
