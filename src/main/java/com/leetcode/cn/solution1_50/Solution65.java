package com.leetcode.cn.solution1_50;

public class Solution65 {

    public boolean isNumber(String s) {
        if (s == null)
            return false;
        int start = 0, end = s.length() - 1;
        // 去除开始和末尾的空格
        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }
        if (start > end)
            return false;
        // 数字
        boolean hasNum = false;
        // e/E
        boolean hasE = false;
        // 小数点
        boolean hasDot = false;
        // 判断正负
        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }

        while (start <= end) {
            if (s.charAt(start) >= '0' && s.charAt(start) <= '9') {
                // 判断数字
                hasNum = true;
            } else if (s.charAt(start) == 'e' || s.charAt(start) == 'E') {
                // 如果前面已经出现'e/E'或者'e/E'前面没出现数字
                if (hasE || !hasNum)
                    return false;
                hasE = true;
                // 数字标志变为false，'e/E'后面再出现数字该标志变为true
                hasNum = false;

            } else if (s.charAt(start) == '.') {
                // 如果'.'前面出现'.'或'e/E'，则不是有效数字
                if (hasDot || hasE)
                    return false;
                hasDot = true;
            } else if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                // 如果'+/-'前面有字符且字符不是'e/E'，则不是有效数字
                if (s.charAt(start - 1) != 'e' && s.charAt(start - 1) != 'E')
                    return false;
            } else {
                return false;
            }

            start++;
        }

        // 返回数字标志
        return hasNum;
    }
}
