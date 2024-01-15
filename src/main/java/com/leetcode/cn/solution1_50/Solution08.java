package com.leetcode.cn.solution1_50;

public class Solution08 {
    public int myAtoi(String str) {
        int temp = 1;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                for (int j = i; j < str.length(); j++) {
                    if ((str.charAt(j) == '+' || str.charAt(j) == '-') && j == i) {
                        temp = str.charAt(i) == '+' ? 1 : -1;
                    } else if ((str.charAt(j)) >= 48 && str.charAt(j) <= 57) {
                        int m = (str.charAt(j) - 48) * temp;
                        if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && m < -8)) {
                            return Integer.MIN_VALUE;
                        }
                        if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && m > 7)) {
                            return Integer.MAX_VALUE;
                        }
                        num = num * 10 + m;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return num;
    }
}
