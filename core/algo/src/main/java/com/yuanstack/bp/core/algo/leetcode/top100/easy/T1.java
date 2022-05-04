package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import javax.xml.transform.Source;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hansiyuan
 * @date 2022年05月03日 21:18
 */
public class T1 {

    /**
     * 1、刷题第一遍
     * 1.1、5分钟：读题 + 思考
     * 1.2、直接看解法：注意！多解法，比较解法优劣
     * 1.3、背诵、默写好的解法
     * 2、刷题第二遍
     * 2.1、马上自己写 —> LeetCode 提交
     * 2.2、多种解法比较、体会 —> 优化！
     * 3、刷题第三遍
     * 3.1、过了一天后，再重复做题
     * 3.2、不同解法的熟练程度 —> 专项练习
     * 4、刷题第四遍
     * 4.1、过了一周：反复回来练习相同题目
     * 5、刷题第五遍
     * 5.1、面试前一周恢复性训练
     *
     * @param args args
     */
    public static void main(String[] args) {
        /*
         * 1、暴力解法
         * 2、Map
         */
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum1(nums, target);
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("null");
        }
    }


    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     *
     * @param nums   整数数组 nums
     * @param target 一个整数目标值 target
     * @return 目标值数组下标
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>(nums.length);
        /*
         * 1. 轮询
         * 2. 查找目标值
         */
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>(nums.length);
        /*
         * 1. 轮询
         * 2. 查找目标值
         */
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(target - nums[i])) {
                return new int[]{result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);
        }
        return null;
    }
}
