package com.yuanstack.bp.core.design.behavior.strategy.filesort;

/**
 * @description: 重构排序算法策略
 * @author: hansiyuan
 * @date: 2022/4/1 10:54 AM
 */
public interface RefactorSortAlgStrategy {
    /**
     * 排序算法
     *
     * @param filePath 文件路径
     */
    void sort(String filePath);
}
