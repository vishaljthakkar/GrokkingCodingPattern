package com.educative.io.pattern.o8inplacereversallinkedlist.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;
/*
Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

Solution:
The problem follows the In-place Reversal of a LinkedList pattern and is quite similar to Reverse every K-element
Sub-list. The only difference is that we have to skip ‘k’ alternating elements. We can follow a similar approach,
and in each iteration after reversing ‘k’ elements, we will skip the next ‘k’ elements.
 */
public class O4_ReverseAlternatingKElements {

    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (true) {
            // This is to store the pointer to the node. The node after this will be reversed. We will get back previous
            // in the form of head of the reversed sublist below
            ListNode lastNodeOfPreviousPart = previous;
            // After reversing current points to the node after the last node of the reversed list.
            // Currently it is pointing to the node from which we are going to start reversing
            // This will become previous/head of the reversed list and next of should be pointed to current.
            ListNode lastNodeOfSublist = current;
            ListNode next = null; // will be used to temporarily store the next node

            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current; // previous will be the first node of the reversed list
                current = next; // current will be out of the reversed list
            }

            // connect with the previous part
            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous;
            } else { // this means we are changing the very first node (head) of the linkedlist
                head = previous;
            }
            // connect with the last part
            lastNodeOfSublist.next = current;

            // skip 'k' nodes
            for(int i = 0; current != null && i < k; i++) {
                previous = current;
                current = current.next;
            }
            if (current == null) { // we have reached the end of the linked list
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode  result = reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
