package com.yuanstack.bp.core.design.behavior.strategy.filesort;

/**
 * @description: 多线程外部排序
 * @author: hansiyuan
 * @date: 2022/4/1 11:01 AM
 */
public class ConcurrentExternalSortStrategy implements  RefactorSortAlgStrategy {
    @Override
    public void sort(String filePath) {
        System.out.println("多线程外部排序...");
    }
}
