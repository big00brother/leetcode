package com.leetcode.cn.solution1_50;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                rows[i][num]++;
                columns[j][num]++;
                boxes[i / 3][j / 3][num]++;
                if (rows[i][num] > 1 || columns[j][num] > 1 || boxes[i / 3][j / 3][num] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
