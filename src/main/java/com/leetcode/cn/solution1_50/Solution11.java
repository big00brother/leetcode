package com.leetcode.cn.solution1_50;

public class Solution11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
