package com.leetcode.cn.solution1_50;

public class Solution37 {

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        int nextI = i;
        int nextJ = j;
        if (j == 8) {
            nextI++;
            nextJ = 0;
        } else {
            nextJ++;
        }
        if (board[i][j] != '.') {
            return dfs(board, nextI, nextJ);
        }
        for (char num = '1'; num <= '9'; num++) {
            if (isValidSudoku(board, i, j, num)) {
                board[i][j] = num;
                if (dfs(board, nextI, nextJ)) {
                    return true;
                } else {
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board, int i, int j, char c) {
        for (int row = 0; row < 9; row++) {//行是否合法
            if (board[row][j] == c)
                return false;
        }
        for (int col = 0; col < 9; col++) {//列是否合法
            if (board[i][col] == c)
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {//小的block是否合法
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (board[row][col] == c)
                    return false;
            }
        }
        return true;
    }
}
