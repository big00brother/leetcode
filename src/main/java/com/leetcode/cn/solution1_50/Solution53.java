package com.leetcode.cn.solution1_50;

public class Solution53 {

    public int maxSubArray(int[] nums) {
        // 记录以当前位置为结尾的最大子数组和
        int curSum = nums[0];
        // 记录遍历过程中出现的子数组和最大值
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            result = Math.max(curSum, result);
        }
        return result;
    }
}
