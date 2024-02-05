package com.leetcode.cn.solution1_50;

import common.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        //fast结点每次都比上k个结点翻转后的头结点多往后遍历k个结点
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        //说明链表没有k个结点，直接返回头结点
        if (fast == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0, null);
        ListNode tail = dummyNode;
        //每次翻转k个结点后的头结点
        ListNode front = head;
        ListNode after = head.next;
        while (true) {
            //记录每次翻转k个结点后的尾结点
            ListNode tmpTail = null;
            for (int i = 0; i < k - 1; i++) {
                if (i == 0) {
                    //翻转k个结点后的尾结点
                    tmpTail = front;
                }
                if (fast != null) {
                    fast = fast.next;
                }
                //after.next指向front，after和front各往后移动一个结点
                ListNode nextAfter = after.next;
                after.next = front;
                front = after;
                after = nextAfter;
            }
            //当前结果链表的尾结点的next指针指向k个结点翻转后的头结点
            tail.next = front;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == null) {
                //剩余未遍历的结点不到k个，当前k个结点翻转后的尾结点的next指针指向剩余结点的头结点
                tmpTail.next = after;
                break;
            }
            //下次翻转k个结点之前，先将结果链表的尾结点指向当前翻转k个结点后的尾结点
            tail = tmpTail;
            front = after;
            after = after.next;

        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution25 solution25 = new Solution25();
        int k = 2;
        solution25.reverseKGroup(head, k);
    }
}
