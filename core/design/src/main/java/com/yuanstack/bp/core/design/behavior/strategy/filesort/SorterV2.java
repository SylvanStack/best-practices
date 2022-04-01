package com.yuanstack.bp.core.design.behavior.strategy.filesort;

import java.io.File;

/**
 * @description: 待重构的排序处理器V2
 * @author: hansiyuan
 * @date: 2022/4/1 11:05 AM
 */
public class SorterV2 {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        RefactorSortAlgStrategy sortAlg;
        // [0, 6GB)
        if (fileSize < 6 * GB) {
            sortAlg = new QuickSortStrategy();
            // [6GB, 10GB)
        } else if (fileSize < 10 * GB) {
            sortAlg = new ExternalSortStrategy();
            // [10GB, 100GB)
        } else if (fileSize < 100 * GB) {
            sortAlg = new ConcurrentExternalSortStrategy();
        } else { // [100GB, ~)
            sortAlg = new MapReduceSortStrategy();
        }
        sortAlg.sort(filePath);
    }
}
