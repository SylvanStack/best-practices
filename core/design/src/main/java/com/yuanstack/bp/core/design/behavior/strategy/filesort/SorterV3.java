package com.yuanstack.bp.core.design.behavior.strategy.filesort;

import java.io.File;

/**
 * @description: 待重构的排序处理器V3
 * @author: hansiyuan
 * @date: 2022/4/1 11:09 AM
 */
public class SorterV3 {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        RefactorSortAlgStrategy sortAlg;
        // [0, 6GB)
        if (fileSize < 6 * GB) {
            sortAlg = SortAlgStrategyFactory.getSortAlg("QuickSortStrategy");
            // [6GB, 10GB)
        } else if (fileSize < 10 * GB) {
            sortAlg = SortAlgStrategyFactory.getSortAlg("ExternalSortStrategy");
            // [10GB, 100GB)
        } else if (fileSize < 100 * GB) {
            sortAlg = SortAlgStrategyFactory.getSortAlg("ConcurrentExternalSortStrategy");
            // [100GB, ~)
        } else {
            sortAlg = SortAlgStrategyFactory.getSortAlg("MapReduceSortStrategy");
        }
        sortAlg.sort(filePath);
    }
}
