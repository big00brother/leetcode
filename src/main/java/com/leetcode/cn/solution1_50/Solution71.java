package com.leetcode.cn.solution1_50;

import java.util.Stack;

public class Solution71 {

    public String simplifyPath(String path) {
        int i = 0;
        String str = "";
        Stack<String> stack = new Stack<>();
        while (i < path.length()) {
            if (path.charAt(i) == '/') {
                if (str.equals(".") || str.equals("")) {

                } else if (str.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    // 每个入栈的字符串前面加上'/'，方便后续简化路径的处理
                    stack.push("/" + str);
                }
                str = "";
            } else {
                str += path.charAt(i);
            }
            i++;
        }
        // path最后一个字符不为'/'时，最后的str需要单独处理
        if (str.equals(".") || str.equals("")) {

        } else if (str.equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        } else {
            stack.push("/" + str);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        // 当简化路径为空时，返回根目录'/'
        return builder.toString().equals("") ? "/" : builder.toString();
    }

}
