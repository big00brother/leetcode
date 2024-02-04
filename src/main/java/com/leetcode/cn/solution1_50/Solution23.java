package com.leetcode.cn.solution1_50;

import common.ListNode;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for(int i = 0; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0, null);
        ListNode p = dummyNode;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return dummyNode.next;
    }
}
