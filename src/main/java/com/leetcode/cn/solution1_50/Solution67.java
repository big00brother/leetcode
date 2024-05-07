package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution67 {

    public String addBinary(String a, String b) {
        List<Integer> list = new ArrayList<>();

        // 把位数多的二进制数赋值给a，位数小的二进制数赋值给b，方便后续运算
        if (a.length() < b.length()) {
            String str = a;
            a = b;
            b = str;
        }
        int maxLength = a.length();
        int minLength = b.length();
        char c = '0';
        // 进位
        int add = 0;
        for (int i = 0; i < maxLength; i++) {
            int num1 = a.charAt(a.length() - 1 - i) - c;
            // i < minLength时，a和b相加再加进位
            if (i < minLength) {
                int num2 = b.charAt(b.length() - 1 - i) - c;
                int sum = num1 + num2 + add;
                add = sum / 2;
                list.add(sum % 2);
            } else {
                int sum = num1 + add;
                add = sum / 2;
                list.add(sum % 2);
            }
        }
        // add = 1时，需要加一个高位1
        if (add == 1) {
            list.add(add);
        }
        StringBuilder result = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.append((char) (list.get(i) + (int) c));
        }
        return result.toString();
    }
}
