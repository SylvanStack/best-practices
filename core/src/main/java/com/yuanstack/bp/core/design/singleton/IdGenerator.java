package com.yuanstack.bp.core.design.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hansiyuan
 * @date 2022年03月14日 23:10
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        long id = IdGenerator.getInstance().getId();
        System.out.println(id);
    }
}