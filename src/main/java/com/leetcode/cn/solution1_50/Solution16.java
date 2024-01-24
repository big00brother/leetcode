package com.leetcode.cn.solution1_50;

import java.util.Arrays;

public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // 最接近target的结果
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        // 离target最接近的数字间距
        int minInterval = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                // 判断与上一个数字是否相等
                if (l != i + 1 && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                if (r != nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                int val = nums[i] + nums[l] + nums[r];
                // 三数之和小于target，l++；三数之和大于target，r--
                if (val <= target) {
                    l++;
                } else {
                    r--;
                }
                // 不断更新最接近的三数之和以及最小间距
                int curInterval = Math.abs(val - target);
                if (curInterval < minInterval) {
                    result = val;
                    minInterval = curInterval;
                }
            }
        }
        return result;
    }

}
