package com.leetcode.cn.solution1_50;

public class Solution59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        // 起始行
        int sr = 0;
        // 起始列
        int sc = 0;
        // 结束行
        int er = n - 1;
        // 结束列
        int ec = n - 1;
        int num = 1;
        while (sr <= er && sc <= ec) {
            // 起始行、起始列、结束行、结束列在同一位置，只剩最后一个元素
            if (sr == er && sc == ec) {
                matrix[sr][sc] = num++;
                break;
            }
            // 其余情况，按照右、下、左、上的顺序遍历
            for (int i = sc; i < ec; i++) {
                matrix[sr][i] = num++;
            }
            for (int i = sr; i < er; i++) {
                matrix[i][ec] = num++;
            }
            for (int i = ec; i > sc; i--) {
                matrix[er][i] = num++;
            }
            for (int i = er; i > sr; i--) {
                matrix[i][sc] = num++;
            }
            // 每遍历完一圈，起始行、起始列、结束行、结束列往内缩一格
            sr++;
            sc++;
            er--;
            ec--;
        }
        return matrix;
    }

}
