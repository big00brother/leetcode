package com.leetcode.cn.solution1_50;

public class Solution6 {
    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] mat = new StringBuilder[Math.min(s.length(), numRows)];
        for (int i = 0; i < mat.length; i++) {
            mat[i] = new StringBuilder();
        }
        int r = 0;
        //代表r的遍历方向，false代表r向下遍历，true代表r向上遍历
        boolean transformFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (r == 0) {
                transformFlag = false;
            } else if (r == mat.length - 1) {
                transformFlag = true;
            }
            if (!transformFlag) {
                mat[r++].append(s.charAt(i));
            } else {
                mat[r--].append(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            res.append(mat[i]);
        }
        return res.toString();
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] c = new char[s.length()];
        //一次z字遍历的长度
        int length = (numRows - 1) * 2;
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j += length) {
                    c[index++] = s.charAt(j);
                }
            } else {
                int j = i;
                //false代表加前半截的字符，true代表加后半截的字符
                boolean flag = false;
                while (j < s.length()) {
                    c[index++] = s.charAt(j);
                    if (!flag) {
                        flag = true;
                        j = j + (numRows - (i + 1)) * 2;
                    } else {
                        flag = false;
                        j = j + i * 2;
                    }
                }
            }
        }
        return new String(c);
    }
}
