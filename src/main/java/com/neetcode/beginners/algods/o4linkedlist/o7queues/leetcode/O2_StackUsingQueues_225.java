package com.neetcode.beginners.algods.o4linkedlist.o7queues.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/
public class O2_StackUsingQueues_225 {
    static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            // add the element to the queue, say 5
            queue.offer(x);
            /*
                Example: 1, 2, 3, 4, 5. We want 5 in the front
                i = 1 => 2, 3, 4, 5, 1 (1<5)
                i = 2 => 3, 4, 5, 1, 2 (2<5)
                i = 3 => 4, 5, 1, 2, 3 (3<5)
                i= 4 => 5, 1, 2, 3, 4  (4<5)
                i = 5 -> breaks the loop
             */
            for (int i = 1; i < queue.size(); i++)
                queue.offer(queue.poll());
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
