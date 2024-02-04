package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, "", result);
        return result;
    }


    //left左括号数，right右括号数，n是括号对数，str是括号字符串，list是匹配的结果集
    public void dfs(int left, int right, int n, String str, List<String> list) {
        //右括号比左边的左括号多或者左括号超过了n个，则str字符串不是有效的括号组合
        if (right > left || left > n) {
            return;
        }
        //当左括号和右括号都是n时，有效的括号组合添加到结果集
        if (left == n && right == n) {
            list.add(str);
        }
        dfs(left + 1, right, n, str + '(', list);
        dfs(left, right + 1, n, str + ')', list);
    }
}
