package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return list;
        }
        int size = words[0].length();
        int len = words.length;
        // 记录words数组中字符串的map，key是字符串，value是字符串出现次数
        Map<String, Integer> map = new HashMap<>();
        // 记录当前遍历的字符串s中匹配words数组中字符串的map，简称为滑动窗口map，key是字符串，value是字符串出现次数
        Map<String, Integer> curMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        // s字符串以 0 ~ size - 1为起点，每次匹配size个字符
        for (int i = 0; i < size; i++) {
            // 当前curMap字符串数量
            int count = 0;
            // 滑动窗口左边界
            int start = i;
            // 每次匹配size个字符
            for (int j = i; j <= s.length() - size; j += size) {
                String cur = s.substring(j, j + size);
                // words中有cur这个字符串
                if (map.containsKey(cur)) {
                    curMap.put(cur, curMap.getOrDefault(cur, 0) + 1);
                    count++;
                    // 当cur出现的次数大于words中的次数时，一直移动滑动窗口左边界，直到左边界出掉一个cur字符串
                    while (curMap.get(cur) > map.get(cur)) {
                        String left = s.substring(start, start + size);
                        curMap.put(left, curMap.get(left) - 1);
                        start = start + size;
                        count--;
                    }
                    // 匹配的字符串数量与words中的字符串数量相等，将滑动窗口左边界加入结果集，滑动窗口左边界往后移动size
                    if (count == len) {
                        list.add(start);
                        String left = s.substring(start, start + size);
                        curMap.put(left, curMap.get(left) - 1);
                        start = start + size;
                        count--;
                    }
                } else {
                    // words中没有匹配字符串，清理滑动窗口，滑动窗口左边界移动到下一个字符串开始位置
                    curMap.clear();
                    start = j + size;
                    count = 0;
                }
            }
            curMap.clear();
        }
        return list;
    }
}
