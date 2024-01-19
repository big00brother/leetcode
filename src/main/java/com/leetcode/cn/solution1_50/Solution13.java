package com.leetcode.cn.solution1_50;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {

    public int romanToInt1(String s) {
        int[] numbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int num = 0;
        // index为字符串s的索引
        int index = 0;
        // index1为symbol起始遍历位置的索引
        int index1 = 0;
        while (index < s.length()) {
            for (int i = index1; i < symbol.length; i++) {
                int length = symbol[i].length();
                if (s.length() - index >= length) {
                    String s1 = s.substring(index, index + length);
                    if (s1.compareTo(symbol[i]) == 0) {
                        num += numbers[i];
                        index += symbol[i].length();
                        index1 = i;
                        break;
                    }
                }
            }
        }
        return num;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> symbolMap = new HashMap<>();
        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = symbolMap.get(s.charAt(i));
            if (i < s.length() - 1 && value < symbolMap.get(s.charAt(i + 1))) {
                num -= value;
            } else {
                num += value;
            }
        }
        return num;
    }
}
