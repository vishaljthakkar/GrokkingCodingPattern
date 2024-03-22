package com.educative.io.pattern.o5fastandslowptr.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;

// https://leetcode.com/problems/linked-list-cycle/description/
public class O1_LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
