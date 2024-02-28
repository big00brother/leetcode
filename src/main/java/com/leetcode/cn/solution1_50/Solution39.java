package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> curNums = new ArrayList<>();
        dfs(candidates, target, result, curNums, 0, 0);
        return result;
    }

    /**
     * @param candidates 从小到大排序后的候选数组
     * @param target     目标值
     * @param result     结果集集合，是个引用
     * @param curNums    当前参与计算的数字集合
     * @param curSum     当前参与计算的数字之和
     * @param start      dfs遍历数组开始的位置
     */
    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> curNums, int curSum, int start) {
        for (int i = start; i < candidates.length; i++) {
            // 当前参与计算的数字之和等于target，添加结果集，并跳出当前dfs
            if (curSum + candidates[i] == target) {
                curNums.add(candidates[i]);
                // 添加结果集的时候需要再new一个list，不然会添加引用，引用会不断变化。
                result.add(new ArrayList<>(curNums));
                curNums.remove(curNums.size() - 1);
                return;
            }
            // 当前参与计算的数字之和大于target，直接跳出当前dfs
            if (curSum + candidates[i] > target) {
                return;
            }
            // 当前参与计算的数字之和小于target，继续dfs，不过下一次的dfs起始位置start为i
            curNums.add(candidates[i]);
            dfs(candidates, target, result, curNums, curSum + candidates[i], i);
            curNums.remove(curNums.size() - 1);
        }
    }
}
