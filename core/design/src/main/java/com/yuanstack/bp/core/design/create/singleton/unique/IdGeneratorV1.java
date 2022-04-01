package com.yuanstack.bp.core.design.create.singleton.unique;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 懒汉式
 * 缺点不支持高并发
 * @author: hansiyuan
 * @date: 2022/4/1 5:41 PM
 */
public class IdGeneratorV1 {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorV1 instance;

    private IdGeneratorV1() {
    }

    public static synchronized IdGeneratorV1 getInstance() {
        if (instance == null) {
            instance = new IdGeneratorV1();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
