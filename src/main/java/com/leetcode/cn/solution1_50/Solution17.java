package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        String[] str = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder bd = new StringBuilder();
        letterCore(bd, str, list, digits, 0);
        return list;
    }

    // dfs遍历。bd存储组合的字符串；str为字母数组，对应索引为数字；list是结果集；digits是数字字符串；i为遍历深度。
    public void letterCore(StringBuilder bd, String[] str, List<String> list, String digits, int i) {
        // 当遍历深度与数字字符串长度相等时，list添加组合字符串，dfs遍历结束
        if (i == digits.length()) {
            list.add(bd.toString());
            return;
        }
        int num = digits.charAt(i) - '0';
        int length = str[num].length();
        int index = 0;
        while (index < length) {
            bd.append(str[num].charAt(index));
            letterCore(bd, str, list, digits, i + 1);
            bd.deleteCharAt(bd.length() - 1);
            index++;
        }
    }
}
