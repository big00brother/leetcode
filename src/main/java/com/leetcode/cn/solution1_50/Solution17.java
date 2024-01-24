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

    public void letterCore(StringBuilder bd, String[] str, List<String> list, String digits, int i) {
        if (i >= digits.length()) {
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
