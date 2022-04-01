package com.yuanstack.bp.core.design.behavior.strategy.filesort;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 排序策略工厂
 * @author: hansiyuan
 * @date: 2022/4/1 11:08 AM
 */
public class SortAlgStrategyFactory {
    private static final Map<String, RefactorSortAlgStrategy> algs = new HashMap<>();

    static {
        algs.put("QuickSortStrategy", new QuickSortStrategy());
        algs.put("ExternalSortStrategy", new ExternalSortStrategy());
        algs.put("ConcurrentExternalSortStrategy", new ConcurrentExternalSortStrategy());
        algs.put("MapReduceSortStrategy", new MapReduceSortStrategy());
    }

    public static RefactorSortAlgStrategy getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return algs.get(type);
    }
}
