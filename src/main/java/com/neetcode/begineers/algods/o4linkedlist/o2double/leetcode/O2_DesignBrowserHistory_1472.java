package com.neetcode.begineers.algods.o4linkedlist.o2double.leetcode;

// https://leetcode.com/problems/design-browser-history/
public class O2_DesignBrowserHistory_1472 {


    static class BrowserHistory {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;
        DoublyLinkedListNode current;
        private static class DoublyLinkedListNode {
            String url;

            DoublyLinkedListNode next;
            DoublyLinkedListNode prev;

            public DoublyLinkedListNode(String url) {
                this.url = url;
            }
        }

        public BrowserHistory(String homepage) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(homepage);
            head = newNode;
            tail = newNode;
            current = newNode;
        }

        // Given in this question that "visit" obliterates the forward history
        // There is a possibility that current will diverge from the tail.
        // This is the reason for below if condition
        public void visit(String url) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(url);
            if (current == tail) {
                newNode.prev = tail;
                tail.next = newNode;

                tail = newNode;
                current = tail;
            } else {
                newNode.prev = current;
                current.next = newNode;
                tail = newNode;
                current = tail;
            }
        }

        public String back(int steps) {
            while(current.prev != null && steps > 0) {
                current = current.prev;
                steps--;
            }
            return current.url;
        }

        public String forward(int steps) {
            while(current.next != null && steps > 0) {
                current = current.next;
                steps--;
            }
            return current.url;
        }
    }
}
