package com.neetcode.beginners.algods.o4linkedlist.o6double.leetcode;

// https://leetcode.com/problems/design-linked-list/
public class O1_DesignLinkedList_707 {

    static class MyLinkedList {
        DoublyLinkedListNode head;
        DoublyLinkedListNode tail;
        int size;

        private static class DoublyLinkedListNode {

            public int val;
            public  DoublyLinkedListNode next;
            public DoublyLinkedListNode prev;
            public DoublyLinkedListNode(int val) {
                this.val = val;
            }
        }
        public MyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        // If index is in the first half start from head or else start from tail.
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            DoublyLinkedListNode current;
            if (index < size / 2) {
                current = head;
                for(int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for(int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }
            return current.val;
        }

        public void addAtHead(int val) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }

        public void addAtTail(int val) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
            if (size == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
                DoublyLinkedListNode current = head;
                for(int i = 0; i < index; i++) {
                    current = current.next;
                }
                newNode.prev = current.prev;
                newNode.next = current;

                current.prev.next = newNode;
                current.prev = newNode;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.prev = null;
                }
            } else if (index == size - 1) {
                tail = tail.prev;
                tail.next = null;
            } else {
                DoublyLinkedListNode current = head;
                for(int i = 0; i < index; i++) {
                    current = current.next;
                }
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
            }
            size--;
        }
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        linkedList.get(1);
    }
}
