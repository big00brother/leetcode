package com.leetcode.cn.solution1_50;

public class Solution45 {
    public int jump(int[] nums) {
        // 数组长度小于等于1时，跳跃次数为0
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        // 当前步数可以到达的最远位置
        int end = 0;
        // 当前步数 +1 可以到达的最远位置
        int maxPosition = end;
        // 当前位置
        int curPosition = 0;
        // 跳跃次数
        int jumps = 0;
        // 从当前位置 遍历 到达 当前步数可以到达的最远位置
        while(curPosition <= end) {
            // 当前步数 +1 可以到达的最远位置 在 遍历的过程中不断更新
            maxPosition = Math.max(maxPosition, nums[curPosition] + curPosition);
            // 若maxPosition超过或等于数组最后一个元素的位置，则返回jumps + 1
            if(maxPosition >= nums.length - 1) {
                return jumps + 1;
            }
            // 当当前位置 遍历到 当前步数可以到达的最远位置时，跳跃次数 + 1, 当前步数可以到达的最远位置 更新为 当前步数 +1 可以到达的最远位置, jumps++
            if(curPosition == end) {
                jumps++;
                end = maxPosition;
            }
            curPosition++;
        }
        return 0;
    }
}
