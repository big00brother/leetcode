package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution22_2 {
    public List<String> generate(int n, List<String>[] cache) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int k = 0; k < n; k++) {
                for (String left : generate(k, cache)) {
                    for (String right : generate(n - 1 - k, cache)) {
                        //"("即为第一个左括号，")"即为第一个左括号对应的右括号，
                        // left即为k对括号中的一种有效组合，right即为n-1-k对括号中的一种有效组合
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        List<String>[] cache = new ArrayList[n + 1];
        return generate(n, cache);
    }
}
