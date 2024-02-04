package com.leetcode.cn.solution1_50;

import common.ListNode;

import java.util.PriorityQueue;

public class Solution23_2 {
    class Status implements Comparable<Status> {
        public ListNode node;

        public Status(ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(Status status) {
            return this.node.val - status.node.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0, null);
        ListNode curNode = dummyNode;
        PriorityQueue<Status> minHeap = new PriorityQueue<>();
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(new Status(node));
            }
        }
        while (!minHeap.isEmpty()) {
            Status status = minHeap.poll();
            curNode.next = status.node;
            curNode = status.node;
            if (status.node.next != null) {
                minHeap.offer(new Status(status.node.next));
            }
        }
        return dummyNode.next;
    }
}
