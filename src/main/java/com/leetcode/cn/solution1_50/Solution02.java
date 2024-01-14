package com.leetcode.cn.solution1_50;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode point = null;
        int add = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + add;
            if (val > 9) {
                val = val % 10;
                add = 1;
            } else {
                add = 0;
            }
            if (head == null) {
                head = new ListNode(val);
                point = head;
            } else {
                point.next = new ListNode(val);
                point = point.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + add;
            if (val > 9) {
                val = val % 10;
                add = 1;
            } else {
                add = 0;
            }
            point.next = new ListNode(val);
            point = point.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + add;
            if (val > 9) {
                val = val % 10;
                add = 1;
            } else {
                add = 0;
            }
            point.next = new ListNode(val);
            point = point.next;
            l2 = l2.next;
        }
        if (add == 1) {
            point.next = new ListNode(1);
        }
        return head;
    }
}
