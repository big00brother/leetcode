package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> results = new ArrayList<>();
        results.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] curInterval = results.get(results.size() - 1);
            // 前面元素的右区间 < 后面元素的左区间
            if (curInterval[1] < intervals[i][0]) {
                results.add(intervals[i]);
            } else {
                // 前面元素的右区间 >= 后面元素的左区间，需要将两个区间合并
                int[] interval = new int[] {curInterval[0], Math.max(curInterval[1], intervals[i][1])};
                results.remove(results.size() - 1);
                results.add(interval);
            }

        }
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        Solution56 s = new Solution56();
        int[][] intervals = new int[][]{new int[]{3, 6}, new int[]{2, 4}, new int[]{1, 3}, new int[]{7, 8}};
        int[][] results = s.merge(intervals);
        System.out.println(results);
    }

}
