package com.educative.io.pattern.o5fastandslowptr.leetcode;

import com.neetcode.beginners.algods.o4linkedlist.o5single.ListNode;

import java.util.Stack;

// https://leetcode.com/problems/palindrome-linked-list/description/
public class O5_PalindromeLinkedList_234 {
    public static boolean isPalindrome(ListNode head) {
        return usingReverse(head);
        // return usingStack(head);
    }

    public static boolean usingReverse(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;       // slow is at the middle of a linkedlist
            fast = fast.next.next;  // fast is at the end of the linkedlist
        }

        slow = reverse(slow);
        // slow = reverseRecursion(slow);

        fast = head;
        while(slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
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

    public static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }

    public static boolean usingStack(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // This is to handle if list is of odd length
        if (fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is Palindrome: " + isPalindrome(head));

        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is Palindrome: " + isPalindrome(head));
    }
    // Is Palindrome: true
    // Is Palindrome: false
}
