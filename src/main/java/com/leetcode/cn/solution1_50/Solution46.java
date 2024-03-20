package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        // 记录排列标记（true代表该位置的数字已加入到排列中，false代表未加入）
        boolean[] flags = new boolean[nums.length];
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        dfs(nums, flags, 0, permutation, permutations);
        return permutations;
    }

    public void dfs(int[] nums, boolean[] flags, int depth, List<Integer> permutation, List<List<Integer>> permutations) {
        if (depth == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i]) {
                continue;
            }
            flags[i] = true;
            permutation.add(nums[i]);
            dfs(nums, flags, depth + 1, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            flags[i] = false;
        }
    }

}
