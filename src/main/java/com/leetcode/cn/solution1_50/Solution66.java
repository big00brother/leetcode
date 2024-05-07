package com.leetcode.cn.solution1_50;

public class Solution66 {

    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + add;
            // sum = 10时下一位需要 + 1
            add = sum / 10;
            digits[i] = sum % 10;
            // 下一位不需要 + 1，后面的数字不需要参与运算
            if (add == 0) {
                return digits;
            }
        }
        // add = 1，结果需要多增加一个高位1
        int[] result = new int[digits.length + 1];
        result[0] = add;
        for (int i = 1; i < result.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }
}
