package com.neetcode.begineers.algods.o4linkedlist.o1single.leetcode;

import com.neetcode.begineers.algods.o4linkedlist.o1single.ListNode;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class O2_MergeTwoSortedList_21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        result.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node7 = new ListNode(7);
        ListNode node9 = new ListNode(9);
        ListNode node0 = new ListNode(0);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        ListNode node8 = new ListNode(8);

        node1.next=node3; node3.next = node5; node5.next = node7; node7.next = node9;
        node0.next=node2; node2.next = node4; node4.next = node6; node6.next = node8;

        ListNode current = mergeTwoLists(node1, node0);
        while(current != null) {
            System.out.print(current.val + " => ");
            current = current.next;
        }
        System.out.println("null");
    }
}
