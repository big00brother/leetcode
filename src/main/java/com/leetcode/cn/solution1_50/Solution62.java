package com.leetcode.cn.solution1_50;

public class Solution62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths02(int m, int n) {
        int small = Math.min(m, n) - 1;
        double a = 1;
        double b = 1;
        int total = m + n - 2;
        for (int i = 0; i < small; i++) {
            a = a * (total - i);
            b = b * (i + 1);
        }
        return (int) (a / b);
    }
}
