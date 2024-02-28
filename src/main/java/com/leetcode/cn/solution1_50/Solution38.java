package com.leetcode.cn.solution1_50;

public class Solution38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 得到上一项的结果
        String pre_result = countAndSay(n - 1);
        int i = 0;
        // 记录当前数字字符出现的次数
        int len = 0;
        // 记录当前数字字符
        char c = pre_result.charAt(0);
        StringBuilder sb = new StringBuilder();
        while (i < pre_result.length()) {
            if (pre_result.charAt(i) == c) {
                len++;
            } else {
                sb.append(len);
                sb.append(c);
                c = pre_result.charAt(i);
                len = 1;
            }
            i++;
        }
        sb.append(len);
        sb.append(c);
        return sb.toString();
    }
}
