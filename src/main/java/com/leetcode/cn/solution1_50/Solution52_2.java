package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution52_2 {

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        // 以下数组记录列、对角线是否已被棋子占用
        // 列
        int[] col = new int[n];
        // 右上到左下的对角线
        int[] dpos = new int[2 * n - 1];
        // 左上到右下的对角线
        int[] dneg = new int[2 * n - 1];
        // total数组引用传参，total[0]记录结果，total[0]初始化时默认值为0
        int[] total = new int[1];
        dfs(total, col, dpos, dneg, n, 0);
        return total[0];
    }

    // index代表当前遍历深度，即棋盘行数
    public void dfs(int[] total, int[] col, int[] dpos, int[] dneg, int n, int index) {
        if (index == n) {
            total[0]++;
            return;
        }
        // i代表列
        for (int i = 0; i < n; i++) {
            // 检查该列和对角线是否已被前面放置的棋子占用
            if (col[i] == 1 || dpos[index + i] == 1 || dneg[index - i + n - 1] == 1) {
                continue;
            }
            col[i] = 1;
            dpos[index + i] = 1;
            dneg[index - i + n - 1] = 1;
            dfs(total, col, dpos, dneg, n, index + 1);
            col[i] = 0;
            dpos[index + i] = 0;
            dneg[index - i + n - 1] = 0;
        }
    }
}
