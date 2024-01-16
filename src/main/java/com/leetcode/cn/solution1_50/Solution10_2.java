package com.leetcode.cn.solution1_50;

public class Solution10_2 {
    public boolean isVaild(char[] s, char[] p) {
        for (int i = 0; i < s.length; i++) {
            if (!(s[i] >= 'a' && s[i] <= 'z')) {
                return false;
            }
        }
        for (int i = 0; i < p.length; i++) {
            if ((p[i] >= 'a' && p[i] <= 'z') || p[i] == '.' || p[i] == '*') {
                if (p[i] == '*' && i == 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean process(char[] s, char[] p, int si, int pi) {
        // pi匹配到末尾时
        if (pi == p.length) {
            return si == s.length;
        }
        // pi在最后一个字符位置 或者 pi+1位置的字符不等于'*'
        if (pi == p.length - 1 || p[pi + 1] != '*') {
            // si匹配完了 或者 （pi位置的字符不是'.'并且pi位置的字符不等于si位置的字符）
            if (si == s.length || (p[pi] != '.' && p[pi] != s[si])) {
                return false;
            }
            // pi的位置是'.'
            return process(s, p, si + 1, pi + 1);
        }
        // 设pi位置的字符为c，pi+1位置的字符为'*'，process为true时，认为匹配了0个c。
        if (!process(s, p, si, pi + 2)) {
            while (si < s.length && (p[pi] == '.' || s[si] == p[pi])) {
                si++;
                if (process(s, p, si, pi + 2)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        if (!isVaild(cs, cp)) {
            return false;
        }
        return process(cs, cp, 0, 0);
    }
}
