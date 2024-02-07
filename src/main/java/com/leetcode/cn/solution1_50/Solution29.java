package com.leetcode.cn.solution1_50;

public class Solution29 {
    public int divide1(int dividend, int divisor) {
        //记录正负标记
        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        //记录商
        long quotient = 0;
        while (dvs <= dvd) {
            long mul = 1;
            long temp = dvs;
            while ((temp << 1) <= dvd) {
                temp = temp << 1;
                mul = mul << 1;
            }
            dvd = dvd - temp;
            quotient = quotient + mul;
        }
        long result = quotient * sign;
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 记录结果正负
        boolean flag = (dividend < 0) ^ (divisor < 0);
        // 将a和b设置为负数，a和b符号相同时方便辗转相减（如果设置为正数，dividend或divisor有一方是Integer.MIN_VALUE时，a或b转化为正数会越界）
        int a = (dividend < 0) ? dividend : -dividend;
        int b = (divisor < 0) ? divisor : -divisor;
        //记录结果
        int result = 0;
        // a > b时，a / b = 0
        while (a <= b) {
            // 记录倍增倍数
            int mul = 1;
            // 用temp临时记录b
            int temp = b;
            // 当temp + temp >= a时，mul倍增，temp倍增（之所以用减法是因为temp相加可能会超过整形范围）
            while (a - temp <= temp) {
                mul += mul;
                temp += temp;
            }
            // a减去倍增后的temp，剩余的a再与b相除
            a -= temp;
            result += mul;
        }
        return flag ? -result : result;
    }
}
