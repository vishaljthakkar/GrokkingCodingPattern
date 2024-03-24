package com.educative.io.pattern.o8inplacereversallinkedlist.leetcode;

/*
Solution
Another way of defining the rotation is to take the sub-list of ‘k’ ending nodes of the LinkedList and connect
them to the beginning. Other than that we have to do three more things:
1. Connect the last node of the LinkedList to the head, because the list will have a different tail after the rotation.
2. The new head of the LinkedList will be the node at the beginning of the sublist.
3. The node right before the start of sub-list will be the new tail of the rotated LinkedList.
 */
// https://leetcode.com/problems/rotate-list/

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;

public class O5_RotateList_61 {
    public static ListNode rotateRight(ListNode head, int rotations) {
        // one node or no rotation
        if (head == null || head.next == null || rotations <= 0) {
            return head;
        }

        // find the length and last node of the list
        ListNode lastNode = head;
        int listLength = 1;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            listLength = listLength + 1;
        }

        // connect the last node with the head to make it a circular list;
        lastNode.next = head;
        // no need to do rotations more than the length of the list
        rotations = rotations % listLength;

        int skipLength = listLength - rotations;
        ListNode lastNodeOfRotatedList = head;
        for(int i = 0; i < skipLength - 1; i++) {
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }

        // 'lastNodeOfRotatedList' is pointing to the sublist of 'k/rotations' ending nodes
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        ListNode  result = rotateRight(head, 8);
        System.out.print("Nodes of the rotated LinkedList are: ");
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
        // Nodes of the rotated LinkedList are: 3 4 5 1 2 
    }
}
