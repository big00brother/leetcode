package com.leetcode.cn.solution1_50;

import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 符合条件的所有三元组集合
        List<List<Integer>> list = new ArrayList<>();
        // 前两个数字相加后，便于查找相加为0第三个数字是否存在
        Map<Integer, Integer> map = new HashMap<>();
        // 判断是否有重复元组
        Set<String> set = new HashSet<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > 0) {
                    break;
                }
                if (map.containsKey(-nums[i] - nums[j]) && map.get(-nums[i] - nums[j]) > j) {
                    List<Integer> list1 = new ArrayList<>();
                    StringBuilder bd = new StringBuilder();
                    bd.append(nums[i]);
                    bd.append(nums[j]);
                    String s = bd.toString();
                    if (!set.contains(s)) {
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(-nums[i] - nums[j]);
                        list.add(list1);
                        set.add(s);

                    }
                }

            }
        }
        return list;
    }
}
