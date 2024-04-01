package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        // 记录排列标记（true代表该位置的数字已加入到排列中，false代表未加入）
        boolean[] flags = new boolean[nums.length];
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        dfs(nums, flags, 0, permutation, permutations);
        return permutations;
    }

    // flag记录已选择数字位置，depth是dfs深度，permutation是当前排列，permutations是总的排列结果集
    public void dfs(int[] nums, boolean[] flags, int depth, List<Integer> permutation, List<List<Integer>> permutations) {
        if (depth == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i]) {
                continue;
            }
            // 当前数字与上一个数字相同，且上一个数字在当前dfs使用过，则跳过当前数字，选择后面的数字。
            // 提示：flag[i-1]为true代表以前的dfs中使用过i-1位置的数字，则不能跳过当前数字。只有为false才代表当前dfs使用过。
            // 原因是我们从前往后遍历，flag[i-1]为false代表i-1位置的数字在当前dfs中已经使用过，使用完之后flag[i-1]由true变为了false。
            if (i != 0 && nums[i] == nums[i - 1] && !flags[i - 1]) {
                continue;
            }
            flags[i] = true;
            permutation.add(nums[i]);
            dfs(nums, flags, depth + 1, permutation, permutations);
            // 下一层dfs完成时，记得将当前排列的队尾元素移除，并将flag[i]置为false
            permutation.remove(permutation.size() - 1);
            flags[i] = false;
        }
    }

}
