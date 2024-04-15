package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        // 起始行
        int sr = 0;
        // 起始列
        int sc = 0;
        // 结束行
        int er = matrix.length - 1;
        // 结束列
        int ec = matrix[0].length - 1;
        while (sr <= er && sc <= ec) {
            // 起始行、起始列、结束行、结束列在同一位置，只剩最后一个元素
            if (sr == er && sc == ec) {
                list.add(matrix[sr][sc]);
                break;
            }
            // 起始行等于结束行，起始列小于结束列，还剩最后一列需要遍历
            if (sr == er && sc < ec) {
                for (int i = sc; i <= ec; i++) {
                    list.add(matrix[sr][i]);
                }
                break;
            }
            // 起始列等于结束列，起始行小于结束行，还剩最后一行需要遍历
            if (sr < er && sc == ec) {
                for (int i = sr; i <= er; i++) {
                    list.add(matrix[i][sc]);
                }
                break;
            }
            // 其余情况，按照右、下、左、上的顺序遍历
            for (int i = sc; i < ec; i++) {
                list.add(matrix[sr][i]);
            }
            for (int i = sr; i < er; i++) {
                list.add(matrix[i][ec]);
            }
            for (int i = ec; i > sc; i--) {
                list.add(matrix[er][i]);
            }
            for (int i = er; i > sr; i--) {
                list.add(matrix[i][sc]);
            }
            // 每遍历完一圈，起始行、起始列、结束行、结束列往内缩一格
            sr++;
            sc++;
            er--;
            ec--;
        }
        return list;
    }
}
