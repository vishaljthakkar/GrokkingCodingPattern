package com.neetcode.beginners.algods.o3stack.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/description/
public class O3_MinStack_155 {

    static class MinStack {
        Stack<Integer> queryStack;
        Stack<Integer> minStack;

        public MinStack() {
            queryStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            queryStack.push(val);
            if (!minStack.isEmpty() && val <= minStack.peek()) {
                minStack.push(val);
            } else if (minStack.isEmpty())
                minStack.push(val);
        }

        public void pop() {
            int val = queryStack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            return queryStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        O3_MinStack_155 o3MinStack155 = new O3_MinStack_155();
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
//        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
