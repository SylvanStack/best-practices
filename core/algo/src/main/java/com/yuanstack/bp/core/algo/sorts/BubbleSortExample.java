package com.yuanstack.bp.core.algo.sorts;

/**
 * @description: 冒泡排序
 * @author: hansiyuan
 * @date: 2022/4/7 3:42 PM
 */
public class BubbleSortExample {
    public static void main(String[] args) {

    }


    /**
     * 冒泡排序，a 表示数组，n 表示数组大小
     *
     * @param a a 表示数组
     * @param n n 表示数组大小
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                // 交换
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            if (!flag) {
                // 没有数据交换，提前退出
                break;
            }
        }
    }
}
