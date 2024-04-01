package com.leetcode.cn.solution1_50;

public class Solution48 {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        // 左上角位置
        int tR = 0, tC = 0;
        // 右下角位置
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dR - tR;
        // 每次遍历每个角上的位置顺时针移动一格
        for (int i = 0; i < times; i++) {
            // 临时变量记录左上
            int temp = matrix[tR][tC + i];
            // 左上 = 左下
            matrix[tR][tC + i] = matrix[dR - i][tC];
            // 左下 = 右下
            matrix[dR - i][tC] = matrix[dR][dC - i];
            // 右下 = 右上
            matrix[dR][dC - i] = matrix[tR + i][dC];
            // 右上 = 左上
            matrix[tR + i][dC] = temp;
        }
    }

}
