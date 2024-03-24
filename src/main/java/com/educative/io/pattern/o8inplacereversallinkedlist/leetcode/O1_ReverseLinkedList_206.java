package com.educative.io.pattern.o8inplacereversallinkedlist.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;

public class O1_ReverseLinkedList_206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode reversedHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;

        reverseList(node1);
        ListNode current = node5;
        while(current != null) {
            System.out.print(current.val + " => ");
            current = current.next;
        }
        System.out.println("null");

        reverseRecursion(node5);
        current = node1;
        while(current != null) {
            System.out.print(current.val + " => ");
            current = current.next;
        }
        System.out.println("null");
    }
}
