package com.leetcode.cn.solution1_50;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[l]) {
                nums[++l] = nums[i];
            }
        }
        return l + 1;
    }
}
