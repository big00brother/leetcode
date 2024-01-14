package com.leetcode.cn.solution1_50;

public class Solution05 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] c = s.toCharArray();
        char[] cc = getManaC(c);
        int[] rs = getManacher(cc);
        int maxLen = 0;
        int maxIndex = 0;
        for (int i = 0; i < rs.length; i++) {
            if (rs[i] > maxLen) {
                maxLen = rs[i];
                maxIndex = i;
            }
        }
        int start = maxIndex + 1 - maxLen;
        int end = start + (2 * maxLen - 1);
        StringBuilder bd = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (cc[i] != '#') {
                bd.append(cc[i]);
            }
        }
        return bd.toString();
    }

    public int[] getManacher(char[] cc) {
        int[] rs = new int[cc.length];
        int C = -1;
        int R = -1;
        for (int i = 0; i < cc.length; i++) {
            rs[i] = i < R ? Math.min(rs[C * 2 - i], R - i) : 0;
            while (i - rs[i] >= 0 && i + rs[i] < rs.length) {
                if (cc[i - rs[i]] != cc[i + rs[i]]) {
                    break;
                }
                rs[i]++;
            }
            if (i + rs[i] > R) {
                C = i;
                R = i + rs[i];
            }
        }
        return rs;
    }

    public char[] getManaC(char[] c) {
        int len = c.length * 2 + 1;
        char[] cc = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if ((i & 1) == 0) {
                cc[i] = '#';
            } else {
                cc[i] = c[index++];
            }
        }
        return cc;
    }
}
