package com.leetcode.cn.solution1_50;

public class Solution55 {

    public boolean canJump(int[] nums) {
        // 记录当前可以跳跃到的最远位置
        int maxPosition = 0;
        // 从起点开始遍历，若当前位置 + 跳跃距离 > 当前可以跳跃到的最远位置，更新最远位置，直到当前位置 + 跳跃距离 >= 最后一个下标，返回true
        for(int i = 0; i <= maxPosition; i++) {
            if(nums[i] + i >= nums.length - 1) {
                return true;
            }
            if(nums[i] + i > maxPosition) {
                maxPosition = nums[i] + i;
            }
        }
        // 此时当前可以跳跃到的最远位置 < 最后一个下标，返回false
        return false;
    }

}
