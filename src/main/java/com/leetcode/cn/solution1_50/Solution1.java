package com.leetcode.cn.solution1_50;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (!map.containsKey(num)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(num), i};
            }
        }
        return null;
    }
}
