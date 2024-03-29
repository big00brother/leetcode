package com.leetcode.cn.solution1_50;

public class Solution27 {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val) {
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}
