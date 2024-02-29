package com.leetcode.cn.solution1_50;

public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            // nums[l]对应的数字就在这里
            if (nums[l] == l + 1) {
                l++;
            }
            // nums[l]不在1 ~ nums.length之间，或者nums[l]对应的数字已经出现在对应位置上（例如nums[l]是8，8应该存储到nums[7]，结果nums[7]上已经是8），
            // 那么这个数字就丢弃（其实就是nums[l]和nums[--r]置换，nums[r+1]永远也不会遍历到了）
            else if (nums[l] <= l || nums[l] > r || nums[nums[l] - 1] == nums[l]) {
                nums[l] = nums[--r];
            }
            // nums[l]在1 ~ nums.length之间，把nums[l]置换到对应位置，再遍历到后面置换的位置时，l直接++。
            else {
                swap(nums, l, nums[l] - 1);
            }
        }
        return l + 1;
    }

    // 数组两个位置值交换
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
