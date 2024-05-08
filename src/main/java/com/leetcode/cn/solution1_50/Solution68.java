package com.leetcode.cn.solution1_50;

import java.util.ArrayList;
import java.util.List;

public class Solution68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i = 0;
        // 记录当前行的单词长度
        int curWidth = 0;
        // 记录当前行的单词个数
        int curNums = 0;
        while (i < words.length) {
            // 当前行单词长度 + 下一个单词长度 + 当前行的单词数量（最少空格数量） < 最大宽度，说明可以把下一个单词加入当前行
            if (curWidth + words[i].length() + curNums <= maxWidth) {
                curWidth += words[i].length();
                curNums++;
                i++;
            } else {
                // 空格个数
                int spaces = maxWidth - curWidth;
                int a = 0;
                int b = 0;
                // 当前行单词数 > 1 时
                if (curNums - 1 != 0) {
                    // 除当前行的最后一个单词外，每个单词后面至少加a个空格，前b个单词后面还需要再加1个空格
                    a = spaces / (curNums - 1);
                    b = spaces % (curNums - 1);
                }
                StringBuilder lineBuilder = new StringBuilder();
                for (int j = 0; j < curNums - 1; j++) {
                    // 加单词
                    lineBuilder.append(words[i - curNums + j]);
                    // 加空格
                    for (int k = 0; k < a; k++) {
                        lineBuilder.append(' ');
                    }
                    if (b-- > 0) {
                        lineBuilder.append(' ');
                    }
                }
                // 加当前行的最后一个单词
                lineBuilder.append(words[i - 1]);
                // 如果该行只有一个单词，需要在单词后面的剩余空间加上空格
                if (curNums == 1) {
                    while (spaces-- > 0) {
                        lineBuilder.append(' ');
                    }
                }
                // 当前行加入结果集
                list.add(lineBuilder.toString());
                // 当前行加入结果集后，当前行宽度和当前行单词个数重置为0
                curWidth = 0;
                curNums = 0;
            }
        }
        StringBuilder lineBuilder = new StringBuilder();
        // 最后一行结果集先加单词，再加1个空格
        for (int j = 0; j < curNums - 1; j++) {
            lineBuilder.append(words[i - curNums + j]);
            lineBuilder.append(' ');
        }
        // 剩余空格个数
        int spaces = maxWidth - curWidth - (curNums - 1);
        lineBuilder.append(words[i - 1]);
        // 最后一个单词后面把剩余空格都加上
        while (spaces-- > 0) {
            lineBuilder.append(' ');
        }
        // 最后一行加入结果集
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
