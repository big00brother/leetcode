package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int curWidth = 0;
        int curNums = 0;
        while (i < words.length) {
            if (curWidth + words[i].length() + curNums <= maxWidth) {
                curWidth += words[i].length();
                curNums++;
                i++;
            } else {
                // 空格个数
                int spaces = maxWidth - curWidth;
                int a = 0;
                int b = 0;
                if (curNums - 1 != 0) {
                    a = spaces / (curNums - 1);
                    b = spaces % (curNums - 1);
                }
                StringBuilder lineBuilder = new StringBuilder();
                for (int j = 0; j < curNums - 1; j++) {
                    lineBuilder.append(words[i - curNums + j]);
                    for (int k = 0; k < a; k++) {
                        lineBuilder.append(' ');
                    }
                    if (b-- > 0) {
                        lineBuilder.append(' ');
                    }
                }
                lineBuilder.append(words[i - 1]);
                if (curNums == 1) {
                    while (spaces-- > 0) {
                        lineBuilder.append(' ');
                    }
                }
                list.add(lineBuilder.toString());
                curWidth = 0;
                curNums = 0;
            }
        }
        StringBuilder lineBuilder = new StringBuilder();

        for (int j = 0; j < curNums - 1; j++) {
            lineBuilder.append(words[i - curNums + j]);
            lineBuilder.append(' ');
        }
        // 剩余空格个数
        int spaces = maxWidth - curWidth - (curNums - 1);
        lineBuilder.append(words[i - 1]);
        while (spaces-- > 0) {
            lineBuilder.append(' ');
        }
        list.add(lineBuilder.toString());
        return list;
    }

    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> list = solution68.fullJustify(words, maxWidth);
        System.out.println(list);
    }
}
