package com.leetcode.cn.solution1_50;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 记录反转数组的起始位置
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            // 当左边的数比右边的数小时
            if (nums[i] < nums[i + 1]) {
                // 交换的数是最后两位
                if (i == nums.length - 2) {
                    swap(i, i + 1, nums);
                    return;
                } else {
                    // 比nums[i]大且最接近nums[i]的数的下标
                    int minIndex = i + 1;
                    // nums[i + 1] ~ nums[nums.length - 1]是非严格从大到小排列
                    for (int j = i + 2; j < nums.length; j++) {
                        // 从 nums[i + 1] ~ nums[nums.length - 1]中寻找比nums[i]大且最接近nums[i]的数
                        if (nums[i] < nums[j]) {
                            minIndex = j;
                        } else {
                            break;
                        }
                    }
                    swap(i, minIndex, nums);
                    // 记录反转数组的起始位置
                    index = i + 1;
                    break;
                }
            }
        }

        int l;
        int r = nums.length - 1;
        if (index != -1) {
            l = index;
        } else {
            l = 0;
        }
        //从数组下标 l ~ r 进行数组交换
        while (l < r) {
            swap(l, r, nums);
            l++;
            r--;
        }
    }

    // 数组下标i和j交换函数
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 6, 5, 4};
        Solution31 s = new Solution31();
        s.nextPermutation(nums);
        System.out.println(nums);
    }
}
