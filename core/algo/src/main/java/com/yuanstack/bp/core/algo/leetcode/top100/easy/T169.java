package com.yuanstack.bp.core.algo.leetcode.top100.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author hansiyuan
 * @date 2022年05月04日 16:10
 */
public class T169 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
