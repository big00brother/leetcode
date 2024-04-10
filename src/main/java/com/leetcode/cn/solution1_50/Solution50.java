package com.leetcode.cn.solution1_50;

public class Solution50 {

    public double myPow(double x, int n) {
        // 记录n的正负
        boolean flag = n > 0;
        // 由于负数范围比正数大，所以n一律转化为负数处理
        if (n > 0) {
            n = n * -1;
        }

        double result  = 1;

        while (n < 0) {
            // 余数为-1，代表当前的二进制位为1
            if(n % 2 == -1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        // n为负数时，结果取倒数
        return flag ? result : 1 / result;
    }

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double result = solution50.myPow(2, 10);
        System.out.println(result);
    }

}
