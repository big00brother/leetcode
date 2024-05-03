package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution60 {

    public String getPermutation(int n, int k) {
        // 按从大到小记录排序数字
        List<Integer> list = new ArrayList<>();
        // 记录排序总数
        int total = 1;
        list.add(1);
        for (int i = 2; i <= n; i++) {
            total = total * i;
            list.add(i);
        }

        // 记录结果集
        StringBuilder bd = new StringBuilder();

        while (k != 0) {
            // 去除当前位置的数字后，剩余的排序总数
            total = total / n--;
            // 计算当前位置应该放什么数字
            int i = (k - 1) / total;
            k = k % total;
            // 将当前位置应该放的数字加入结果集
            bd.append(list.get(i));
            // 从列表中移除加入的数字
            list.remove(i);
        }

        // 如果k是0，说明后面的数字按照从大到小的排列加入到结果集中
        if (k == 0) {
            for (int j = list.size() - 1; j >= 0; j--) {
                bd.append(list.get(j));
            }
        }
        return bd.toString();
    }
}
