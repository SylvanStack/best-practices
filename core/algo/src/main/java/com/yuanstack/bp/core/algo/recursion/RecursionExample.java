package com.yuanstack.bp.core.algo.recursion;

/**
 * @description: 去的过程叫“递”，回来的过程叫“归”
 * 1、一个问题的解可拆解为几个子问题的解
 * 2、求解思路一样
 * 3、存在递归终止条件
 * 递归=递推公式+终止条件
 * @author: hansiyuan
 * @date: 2022/4/7 3:47 PM
 */
public class RecursionExample {

    public static void main(String[] args) {
        System.out.println(getSeatIndex(9));
        System.out.println(stepUp(7));
    }

    public static int getSeatIndex(int n) {
        if (n == 1) {
            return 1;
        }
        return getSeatIndex(n - 1) + 1;
    }

    /**
     * 上n阶台阶的方法数 每次走一步或两步
     *
     * @param n 台阶数
     * @return 走法数
     */
    public static int stepUp(int n) {
        // 终止条件
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return stepUp(n - 2) + stepUp(n - 1);
    }
}
