package com.neetcode.begineers.algods.o4linkedlist.o3queues;

public class Queue {
    ListNode forward;  // front of Queue   front -> [1,2,3]
    ListNode back; // back of Queue   [1,2,3] <- back

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public Queue() {
        this.forward = null;
        this.back = null;
    }

    public void enqueue(int val) {
        ListNode newNode = new ListNode(val);
        if (this.back != null) {
            // Queue is not empty
            this.back.next = newNode;
            this.back = this.back.next;
        } else {
            // Queue is empty
            this.forward = newNode;
            this.back = newNode;
        }
    }

    public int dequeue() {
        if (this.forward == null) {
            // Queue is empty
            System.exit(0);
        }
        int val = this.forward.val;
        this.forward = this.forward.next;
        return val;

    }

    public void print() {
        ListNode cur = this.forward;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

}
