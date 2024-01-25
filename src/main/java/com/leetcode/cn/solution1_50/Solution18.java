package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long num1 = nums[i] + nums[j];
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    long totalSum = num1 + (long) nums[l] + (long) nums[r];
                    if (totalSum < (long) target) {
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        l++;
                    } else if (totalSum > (long) target) {
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        r--;
                    } else {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[l]);
                        list1.add(nums[r]);
                        list.add(list1);
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return list;
    }
}
