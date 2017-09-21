package com.cqupt.text.offer;

/**
 * 反转链表
 *
 * @author weigs
 * @date 2017/9/21 0021
 */
public class reverseLink {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        ListNode newHead = null;
        while (p != null) {
            ListNode pNext = p.next;
            if (pNext == null)
                newHead = p;
            p.next = pre;
            pre = p;
            p = pNext;
        }
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
