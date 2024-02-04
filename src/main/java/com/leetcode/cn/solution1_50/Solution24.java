package com.leetcode.cn.solution1_50;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution24 {

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode node = newHead;
        ListNode preNode = head;
        while (true) {
            ListNode nextPreNode = node.next;
            node.next = preNode;
            if (nextPreNode == null || nextPreNode.next == null) {
                preNode.next = nextPreNode;
                break;
            }
            preNode.next = nextPreNode.next;
            preNode = nextPreNode;
            node = nextPreNode.next;
        }
        return newHead;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();
        int num = 0;
        ListNode curNode = head;
        while (curNode != null) {
            if (num % 2 == 0) {
                list2.add(curNode);
            } else {
                list1.add(curNode);
            }
            num++;
            curNode = curNode.next;
        }
        for (int i = 0; i < list1.size(); i++) {
            ListNode node = list1.get(i);
            node.next = list2.get(i);
            //list1没遍历到尾部
            if (i != list1.size() - 1) {
                //list1后面还有结点
                node.next.next = list1.get(i + 1);
            } else {
                //list2比list1多一个元素
                if (list2.size() > list1.size()) {
                    //list2的最后一个元素是最后一个结点
                    node.next.next = list2.get(i + 1);
                } else {
                    //list1和list2元素一样多，list2最后一个结点的next指针指向null
                    node.next.next = null;
                }
            }
        }
        return list1.get(0);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode nextHead = newHead.next;
        newHead.next = head;
        head.next = swapPairs(nextHead);
        return newHead;
    }
}
