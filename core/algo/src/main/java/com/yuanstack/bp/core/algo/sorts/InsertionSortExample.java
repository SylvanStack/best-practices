package com.yuanstack.bp.core.algo.sorts;

/**
 * @description: 插入排序算法
 * @author: hansiyuan
 * @date: 2022/4/7 3:44 PM
 */
public class InsertionSortExample {

    public static void main(String[] args) {

    }

    /**
     * 插入排序
     *
     * @param a a 表示数组
     * @param n n 表示数组大小
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j + 1] = value;
        }
    }
}
