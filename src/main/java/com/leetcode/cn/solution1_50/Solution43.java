package com.leetcode.cn.solution1_50;

public class Solution43 {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        char zero = '0';
        int[] nums = new int[n1.length() + n2.length()];
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                // 各位数字的乘积累加
                nums[i + j] += (n1.charAt(i) - zero) * (n2.charAt(j) - zero);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            // 低位数字除10取余
            int digit = nums[i] % 10;
            // 低位数字除10向高位进位
            int carry = nums[i] / 10;
            if (i < nums.length - 1) {
                nums[i + 1] += carry;
            }
            nums[i] = digit;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 去掉高位0
            if (i != 0 && flag && nums[i] == 0) {
                continue;
            }
            flag = false;
            result.append(nums[i]);
        }
        return result.toString();
    }
}
