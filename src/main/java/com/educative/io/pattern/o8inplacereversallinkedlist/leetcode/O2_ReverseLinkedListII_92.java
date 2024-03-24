package com.educative.io.pattern.o8inplacereversallinkedlist.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;
/*
The problem follows the In-place Reversal of a LinkedList pattern. We can use a similar approach as discussed in
Reverse a LinkedList. Here are the steps we need to follow:
1. Skip the first p-1 nodes, to reach the node at position p.
2. Remember the node at position p-1 to be used later to connect with the reversed sub-list.
3. Next, reverse the nodes from p to q using the same approach discussed in Reverse a LinkedList.
4. Connect the p-1 and q+1 nodes to the reversed sub-list.

Similar Questions #
Problem 1: Reverse the first ‘k’ elements of a given LinkedList.
Solution: This problem can be easily converted to our parent problem; to reverse the first ‘k’ nodes of the list,
we need to pass p=1 and q=k.

Problem 2: Given a LinkedList with ‘n’ nodes, reverse it based on its size in the following way:
1. If ‘n’ is even, reverse the list in a group of n/2 nodes.
2. If n is odd, keep the middle node as it is, reverse the first ‘n/2’ nodes and reverse the last ‘n/2’ nodes.

Solution: When ‘n’ is even we can perform the following steps:
1. Reverse first ‘n/2’ nodes: head = reverse(head, 1, n/2)
2. Reverse last ‘n/2’ nodes: head = reverse(head, n/2 + 1, n)
When ‘n’ is odd, our algorithm will look like:
1. head = reverse(head, 1, n/2)
2. head = reverse(head, n/2 + 2, n)

Please note the function call in the second step. We’re skipping two elements as we will be skipping the middle element.
 */

// https://leetcode.com/problems/reverse-linked-list-ii/description/
public class O2_ReverseLinkedListII_92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // after skipping "left - 1" nodes, current will point to left node.
        ListNode current = head, previous = null;
        for(int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        // we are interested in three parts of the linkedlist, part before "left", part between "left" and "right"
        //, and the part after index "right"

        ListNode lastNodeOfFirstPart = previous; // points to the node at index "left - 1"
        // after reversing the linkedlist "current" will become the last node of the sublist
        ListNode lastNodeOfSubList = current;
        ListNode next = null; // will be used to temporarily store the next node
        for(int i = 0; current != null && i < right - left + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        // connect with the first part
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous; // "previous" is not the first node of the sublist
        } else { // this means left == 1 i.e., we are changing the first node (head) of the linkedlist
            head = previous;
        }

        // connect with the last part
        lastNodeOfSubList.next = current;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode  result = reverseBetween(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}
