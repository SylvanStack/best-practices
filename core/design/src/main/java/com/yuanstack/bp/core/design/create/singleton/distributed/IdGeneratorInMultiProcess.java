package com.yuanstack.bp.core.design.create.singleton.distributed;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 进程间唯一
 * @author: hansiyuan
 * @date: 2022/4/1 5:56 PM
 */
public class IdGeneratorInMultiProcess {
    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorInMultiProcess instance;
    // 入参省略，比如文件地址
    private static SharedObjectStorage storage = fileSharedObjectStorage();

    private static SharedObjectStorage fileSharedObjectStorage() {
        return null;
    }


    private static DistributedLock lock = new DistributedLock();

    private IdGeneratorInMultiProcess() {
    }

    public synchronized static IdGeneratorInMultiProcess getInstance() {
        if (instance == null) {
            lock.lock();
            instance = storage.load(IdGeneratorInMultiProcess.class);
        }
        return instance;
    }

    public synchronized void freeInstance() {
        storage.save(this, IdGeneratorInMultiProcess.class);
        //释放对象
        instance = null;
        lock.unlock();
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        // IdGenerator使用举例
        IdGeneratorInMultiProcess idGeneator = IdGeneratorInMultiProcess.getInstance();
        long id = idGeneator.getId();
        idGeneator.freeInstance();
    }
}
