package com.yuanstack.bp.core.design.behavior.strategy.filesort;

/**
 * @description: 利用MapReduce多机排序
 * @author: hansiyuan
 * @date: 2022/4/1 11:03 AM
 */
public class MapReduceSortStrategy implements RefactorSortAlgStrategy {
    @Override
    public void sort(String filePath) {
        System.out.println("利用MapReduce多机排序...");
    }
}
