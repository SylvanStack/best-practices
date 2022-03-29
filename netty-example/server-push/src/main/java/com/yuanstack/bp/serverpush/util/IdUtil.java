package com.yuanstack.bp.serverpush.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 请求标识ID
 *
 * @author hansiyuan
 */
public final class IdUtil {

    private static final AtomicLong IDX = new AtomicLong();

    private IdUtil() {
        //no instance
    }

    public static long nextId() {
        return IDX.incrementAndGet();
    }

}