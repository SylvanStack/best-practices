package com.yuanstack.bp.core.design.create.singleton.distributed;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 进程内唯一
 * @author: hansiyuan
 * @date: 2022/4/1 5:53 PM
 */
public class IdGeneratorInMultithreading {
    private AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long, IdGeneratorInMultithreading> instances = new ConcurrentHashMap<>();

    private IdGeneratorInMultithreading() {
    }

    public static IdGeneratorInMultithreading getInstance() {
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId, new IdGeneratorInMultithreading());
        return instances.get(currentThreadId);
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
