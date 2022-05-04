package com.yuanstack.bp.core.algo.leetcode.top100.easy;

/**
 * @author hansiyuan
 * @date 2022年05月04日 12:38
 */
public class T52 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, -1, 2, 3};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }
}
