package com.yuanstack.bp.core.design.behavior.strategy.filesort;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 待重构的排序处理器V4
 * @author: hansiyuan
 * @date: 2022/4/1 11:12 AM
 */
public class SorterV4 {
    private static final long GB = 1000 * 1000 * 1000;
    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add(new AlgRange(0, 6 * GB, SortAlgStrategyFactory.getSortAlg("QuickSortStrategy")));
        algs.add(new AlgRange(6 * GB, 10 * GB, SortAlgStrategyFactory.getSortAlg("ExternalSortStrategy")));
        algs.add(new AlgRange(10 * GB, 100 * GB, SortAlgStrategyFactory.getSortAlg("ConcurrentExternalSortStrategy")));
        algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SortAlgStrategyFactory.getSortAlg("MapReduceSortStrategy")));
    }

    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        RefactorSortAlgStrategy sortAlg = null;
        for (AlgRange algRange : algs) {
            if (algRange.inRange(fileSize)) {
                sortAlg = algRange.getAlg();
                break;
            }
        }
        sortAlg.sort(filePath);
    }

    @AllArgsConstructor
    private static class AlgRange {
        private long start;
        private long end;
        @Getter
        private RefactorSortAlgStrategy alg;

        public boolean inRange(long size) {
            return size >= start && size < end;
        }
    }
}
