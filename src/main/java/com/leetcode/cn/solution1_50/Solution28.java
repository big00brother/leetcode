package com.leetcode.cn.solution1_50;

public class Solution28 {
    public int strStr1(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null ||
                haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        int[] next = getNextArr(str2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (i2 > 0) {
                // haystack与needle在needle第i2位置的字符不匹配之时，先让i2回到next[i2]
                // 此时needle从0 ~ i2-1的前缀与haystack从i1-i2 ~ i-1的字符串匹配
                i2 = next[i2];
            } else {
                i1++;
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    // 使用kmp算法计算next最长前缀和数组
    public int[] getNextArr(char[] str) {
        if (str.length == 1) {
            return new int[]{0};
        }
        // next[i]代表以i位置为终点时（不包括i)，最长后缀与最长前缀匹配的长度。后缀的起点位置不能从下标0开始。
        int[] next = new int[str.length];
        // next下标0和1之前都没有后缀与前缀匹配
        next[0] = 0;
        next[1] = 0;
        int i = 2;
        // 最长前缀和计数
        int cnt = 0;
        while (i < next.length) {
            if (str[i - 1] == str[cnt]) {
                next[i++] = ++cnt;
            } else if (cnt > 0) {
                // 当前后缀最后的字符不匹配之时，先让后缀的起始位置移动到更靠后的位置，与next[cnt]处的字符进行比较
                //（此时str的后缀与cnt之前的字符串匹配）
                cnt = next[cnt];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
