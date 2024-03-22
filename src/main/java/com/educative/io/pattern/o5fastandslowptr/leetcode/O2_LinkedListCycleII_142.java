package com.educative.io.pattern.o5fastandslowptr.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class O2_LinkedListCycleII_142 {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { //detected cycle
                ListNode current = head;
                while(current != slow) {
                    current = current.next;
                    slow = slow.next;
                }
                return current;
            }
        }
        return null;
    }

    public static int cycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { //detected cycle
                return calculateCycleLength(slow);
            }
        }
        return 0;
    }

    public static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength = cycleLength + 1;
        } while(current != slow);

        return cycleLength;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;

        System.out.println("LinkedList cycle length: " + cycleLength(head));
        System.out.println("LinkedList Cycle start: " + detectCycle(head).val);
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + cycleLength(head));
        System.out.println("LinkedList Cycle start: " + detectCycle(head).val);
        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle length: " + cycleLength(head));
        System.out.println("LinkedList Cycle start: " + detectCycle(head).val);

        // LinkedList cycle length: 4
        // LinkedList cycle length: 3
    }
}
