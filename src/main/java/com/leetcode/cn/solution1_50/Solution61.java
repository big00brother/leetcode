package com.leetcode.cn.solution1_50;

import common.ListNode;

public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode node = head;
        // 记录尾节点
        ListNode tail = null;
        // 记录链表长度
        int length = 0;
        while(node != null) {
            length++;
            tail = node;
            node = node.next;
        }
        // 当k > length时，对k取余
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        // 快指针
        ListNode fast = dummyNode;
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 利用快慢指针将node指针指向倒数第k个节点
        node = dummyNode;
        // pre指针指向node的前一个节点
        ListNode pre = null;

        while(fast != null) {
            fast = fast.next;
            pre = node;
            node = node.next;
        }
        // 旧链表的尾节点的next指针指向head
        tail.next = head;
        // pre变为了新链表的尾节点，pre节点的next指针指向null
        pre.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        Solution61 solution61 = new Solution61();
        int k = 2;
        ListNode head = solution61.rotateRight(node, k);
    }


}
