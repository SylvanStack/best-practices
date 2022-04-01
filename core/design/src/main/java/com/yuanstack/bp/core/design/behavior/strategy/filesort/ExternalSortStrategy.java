package com.yuanstack.bp.core.design.behavior.strategy.filesort;

/**
 * @description: 外部排序策略
 * @author: hansiyuan
 * @date: 2022/4/1 11:00 AM
 */
public class ExternalSortStrategy implements RefactorSortAlgStrategy {
    @Override
    public void sort(String filePath) {
        System.out.println("外部排序策略...");
    }
}
