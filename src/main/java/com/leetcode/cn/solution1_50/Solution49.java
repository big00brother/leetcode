package com.leetcode.cn.solution1_50;

import java.util.*;

public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String valueStr : strs) {
            char[] cs = valueStr.toCharArray();
            Arrays.sort(cs);
            String keyStr = new String(cs);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(valueStr);
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }
}
