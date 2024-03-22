package com.educative.io.pattern.o5fastandslowptr.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;
// https://leetcode.com/problems/middle-of-the-linked-list/
public class O4_MiddleOfLinkedList_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
