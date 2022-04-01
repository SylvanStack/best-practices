package com.yuanstack.bp.core.design.behavior.strategy.filesort;

import java.io.File;

/**
 * @description: 待重构的排序处理器
 * @author: hansiyuan
 * @date: 2022/4/1 10:50 AM
 */
public class SorterV1 {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        // [0, 6GB)
        if (fileSize < 6 * GB) {
            quickSort(filePath);
            // [6GB, 10GB)
        } else if (fileSize < 10 * GB) {
            externalSort(filePath);
            // [10GB, 100GB)
        } else if (fileSize < 100 * GB) {
            concurrentExternalSort(filePath);
            // [100GB, ~)
        } else {
            mapreduceSort(filePath);
        }
    }

    private void quickSort(String filePath) {
        // 快速排序
    }

    private void externalSort(String filePath) {
        // 外部排序
    }

    private void concurrentExternalSort(String filePath) {
        // 多线程外部排序
    }

    private void mapreduceSort(String filePath) {
        // 利用MapReduce多机排序
    }
}
