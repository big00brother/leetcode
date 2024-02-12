package com.leetcode.cn.solution1_50;

public class Solution33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 区间[l,r]
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // [mid, r]是升序
            if (nums[l] > nums[mid]) {
                // target范围(nums[mid], nums[r]]
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // [l, mid]是升序
            else {
                // target范围[nums[l], nums[mid])
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

}
