package com.leetcode.cn.solution1_50;

public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);
        return new int[]{left, right};
    }

    public int binarySearchLeft(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int left = (r == nums.length || nums[r] != target) ? -1 : r;
        return left;
    }

    public int binarySearchRight(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int right = (r != 0 && nums[r - 1] != target) ? -1 : r - 1;
        return right;
    }
}
