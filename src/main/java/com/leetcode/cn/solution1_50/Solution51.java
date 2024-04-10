package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 以下数组记录行、列、对角线是否已被棋子占用
        // 行
        int[] row = new int[n];
        // 列
        int[] col = new int[n];
        // 右上到左下的对角线
        int[] dpos = new int[2 * n - 1];
        // 左上到右下的对角线
        int[] dneg = new int[2 * n - 1];
        List<List<String>> list = new ArrayList<List<String>>();
        dfs(list, row, col, dpos, dneg, n, 0);
        return list;

    }

    // index代表当前遍历深度，即棋盘行数
    public void dfs(List<List<String>> list, int[] row, int[] col, int[] dpos, int[] dneg, int n, int index) {
        if (index == n) {
            List<String> list1 = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder bd = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (row[i] == j) {
                        bd.append('Q');
                    } else {
                        bd.append('.');
                    }
                }
                list1.add(bd.toString());
            }
            list.add(list1);
            return;
        }
        // i代表列
        for (int i = 0; i < n; i++) {
            // 检查该列和对角线是否已被前面放置的棋子占用
            if (col[i] == 1 || dpos[index + i] == 1 || dneg[index - i + n - 1] == 1) {
                continue;
            }
            // 这里需要注意，行数组存储棋子放置在哪一列
            row[index] = i;
            col[i] = 1;
            dpos[index + i] = 1;
            dneg[index - i + n - 1] = 1;
            dfs(list, row, col, dpos, dneg, n, index + 1);
            col[i] = 0;
            dpos[index + i] = 0;
            dneg[index - i + n - 1] = 0;
        }
    }
}
