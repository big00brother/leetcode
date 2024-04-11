package com.leetcode.cn.solution1_50;

public class Solution52 {

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        // nums[i]下标i代表行，nums[i]的值代表列，nums[i]代表第i行的棋子放置在第nums[i]列
        int[] nums = new int[n];
        // 初始化每一行放置棋子后对应列的位置，实际上nums[0...n-1]的值只要不重复就行，毕竟不同行的棋子不能放在同一列
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        // total数组引用传参，total[0]记录结果
        int[] total = new int[1];
        swapCore(total, nums, 0, n);
        return total[0];

    }

    public void swapCore(int[] total, int[] nums, int index, int n) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    // Math.abs(第i行 - 第j行) == Math.abs(第nums[i]列 - 第nums[j]列)，表示第i行放置的棋子和第j行放置的棋子在同一条对角线上，不符合规定
                    if (Math.abs(i - j) == Math.abs(nums[i] - nums[j])) {
                        return;
                    }
                }
            }
            total[0]++;
            return;
        }
        for (int i = index; i < n; i++) {
            // 第index行选择某一列放置棋子
            swapArray(nums, index, i);
            // 后面的行就不能再选择前面的行放置棋子对应的列了，因为下标index + 1 ~ n - 1之间的nums数组对应的值里没有前面选择过的值
            swapCore(total, nums, index + 1, n);
            // 第index行回退到选择某一列放置棋子前的状态
            swapArray(nums, index, i);
        }
    }

    // 数组值交换
    public void swapArray(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
