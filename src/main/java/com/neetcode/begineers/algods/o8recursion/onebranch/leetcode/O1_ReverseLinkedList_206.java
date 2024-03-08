package com.neetcode.begineers.algods.o8recursion.onebranch.leetcode;

import com.neetcode.begineers.algods.o4linkedlist.o5single.ListNode;

public class O1_ReverseLinkedList_206 {
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode reversedHead = reverse(head.next);
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reverse(node1);

        ListNode current = node5;
        while(current != null) {
            System.out.print(current.val + " => ");
            current = current.next;
        }
        System.out.println("null");
    }
}
