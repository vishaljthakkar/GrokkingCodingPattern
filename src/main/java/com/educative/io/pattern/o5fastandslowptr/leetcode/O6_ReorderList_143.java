package com.educative.io.pattern.o5fastandslowptr.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;

public class O6_ReorderList_143 {
    public static void reorderList(ListNode head) {
        // Fast pointer slow pointer. Find middle of the list
        if (head == null) return;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;       // slow is at the middle of a linkedlist
            fast = fast.next.next;  // fast is at the end of the linkedlist
        }

        // Reverse the list from slow pointer
        slow = reverse(slow);

        // start from the head;
        ListNode current = head;

        while(slow.next != null) {
            ListNode next = current.next;

            current.next = slow;
            current = current.next;
            slow = slow.next;

            current.next = next;
            current = current.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorderList(head);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        // 2 12 4 10 6 8
    }
}
