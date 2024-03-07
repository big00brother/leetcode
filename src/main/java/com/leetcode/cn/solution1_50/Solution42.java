package com.leetcode.cn.solution1_50;

import java.util.Stack;

public class Solution42 {

    public int trap(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<height.length; i++) {
            if(stack.isEmpty()) {
                // 栈为空时加入第一个高度不为0的柱子
                if(height[i] != 0) {
                    stack.push(i);
                }
                continue;
            }
            // 当前柱子比栈顶柱子矮时，当前柱子入栈
            if(height[i] < height[stack.peek()]) {
                stack.push(i);
                continue;
            }
            // 当前柱子比栈顶柱子高时，栈顶柱子出栈，计算积水容量。
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int lastIndex = stack.peek();
                stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                area = area + (Math.min(height[i], height[stack.peek()]) - height[lastIndex]) * (i - stack.peek() - 1);
            }
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                // while循环结束，当前柱子比栈顶柱子矮
                if (height[i] != height[stack.peek()]) {
                    stack.push(i);
                }
                // while循环结束，当前柱子跟栈顶柱子一样高，栈顶柱子出栈，新柱子入栈（为了计算积水容积时能够套用上面的计算公式）
                else {
                    stack.pop();
                    stack.push(i);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution42 s = new Solution42();
        int[] arr = new int[] {5,2,1,2,1,5};
        int area = s.trap(arr);
        System.out.println(area);
    }
}
