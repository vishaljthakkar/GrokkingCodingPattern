package com.neetcode.beginners.algods.o9sorting.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;

        int start = 0, end = length - 1;
        return merge(lists, start, end);
    }

    public static ListNode merge(ListNode[] lists, int start, int end) {
        if (end <= start)
            return lists[start];


        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);


        // compare left and right
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while(left != null && right != null) {
            if (left.val == right.val) {
                result.next = left;
                result = result.next;
                left = left.next;

                result.next = right;
                result = result.next;
                right = right.next;
            } else if (left.val < right.val) {
                result.next = left;
                result = result.next;
                left = left.next;
            } else {
                result.next = right;
                result = result.next;
                right = right.next;
            }
        }

        if (left != null)
            result.next = left;
        if(right != null)
            result.next = right;
        return dummy.next;
    }

    public ListNode mergeKListHeapMethod(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        // PriorityQueue<ListNode> heap = new PriorityQueue<>((i1, i2) -> i1.val - i2.val);
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                heap.offer(lists[i]);
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;

            // Add the next node of this list to the heap
            if (node.next != null)
                heap.offer(node.next);
        }
        return dummy.next;
    }
}
