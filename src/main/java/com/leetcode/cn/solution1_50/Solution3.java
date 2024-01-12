package com.leetcode.cn.solution1_50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 {

    public int lengthOfLongestSubstring1(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int j = i;
            for(; j < s.length(); j++) {
                char a = s.charAt(j);
                if(!set.contains(a)) {
                    set.add(a);
                } else {
                    break;
                }
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char a = s.charAt(j);
            if (map.containsKey(a)) {
                i = Math.max(i, map.get(a));
            }
            map.put(a, j + 1);
            max = Math.max(max, j - i + 1);

        }
        return max;
    }
}
