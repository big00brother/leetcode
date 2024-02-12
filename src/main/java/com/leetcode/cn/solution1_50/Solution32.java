package com.leetcode.cn.solution1_50;

import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 记录有效子串的起始位置
        int start = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        // 栈为空时，有效子串的长度 = 右括号的位置 - 有效子串的起始位置 + 1
                        max = Math.max(max, i - start + 1);
                    } else {
                        // 栈不为空时，有效子串的长度 = 右括号的位置 - 栈顶元素的位置，因为栈顶元素的下一个位置是匹配的'('
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }

        }
        return max;
    }

    public int longestValidParentheses(String s) {
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left += 1;
            } else {
                right += 1;
            }
            if (right > left) {
                left = 0;
                right = 0;
            } else if (right == left) {
                max = Math.max(right * 2, max);
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                left += 1;
            } else {
                right += 1;
            }
            if (left > right) {
                left = 0;
                right = 0;
            } else if (left == right) {
                max = Math.max(left * 2, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        String s = "(()()()";
        int max = solution32.longestValidParentheses1(s);
        System.out.println(max);
    }
}
