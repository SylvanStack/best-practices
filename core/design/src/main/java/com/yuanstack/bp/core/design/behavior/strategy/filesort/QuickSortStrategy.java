package com.yuanstack.bp.core.design.behavior.strategy.filesort;

/**
 * @description: 快速排序策略
 * @author: hansiyuan
 * @date: 2022/4/1 10:58 AM
 */
public class QuickSortStrategy implements RefactorSortAlgStrategy {
    @Override
    public void sort(String filePath) {
        System.out.println("快速排序策略....");
    }
}
