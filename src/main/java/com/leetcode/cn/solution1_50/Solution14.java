package com.leetcode.cn.solution1_50;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefixBuilder = new StringBuilder();
        int l = 0;
        boolean flag = true;
        while(flag) {
            char c = ' ';
            for(int i = 0; i < strs.length; i++) {
                if(strs[i] == null) {
                    flag = false;
                    break;
                }
                if(l == strs[i].length()) {
                    flag = false;
                    break;
                }
                char sc = strs[i].charAt(l);
                if(c == ' ') {
                    c = sc;
                } else if (sc != c) {
                    flag = false;
                    break;
                }
                if(i == strs.length - 1) {
                    prefixBuilder.append(c);
                    l++;
                }
            }
        }
        return prefixBuilder.toString();
    }
}
