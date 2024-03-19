package com.educative.io.pattern.o3monotonicstack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotonicStack {
    private int[] nums;
    private int[] firstSmallerToLeft, firstSmallerToRight;
    private int[] firstLargerToLeft, firstLargerToRight;


    public MonotonicStack(int[] nums) {
        this.nums = nums;
        this.firstSmallerToLeft = new int[nums.length];
        this.firstSmallerToRight = new int[nums.length];
        this.firstLargerToLeft = new int[nums.length];
        this.firstLargerToRight = new int[nums.length];

        Arrays.fill(firstSmallerToLeft, -1);
        Arrays.fill(firstSmallerToRight, -1);
        Arrays.fill(firstLargerToLeft, -1);
        Arrays.fill(firstLargerToRight, -1);

        // Increasing stack will give us
        // firstSmallerToLeft and firstSmallerToRing
        buildIncreasingStack();
        // Decreasing stack will give us
        // firstLargerToLeft and firstLargerToRight
        buildDecreasingStack();
    }

    private void buildIncreasingStack() {
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(len);

        for(int i = 0; i < len; i++) {
            // Number which came before this index is already in the stack
            // and is bigger than current index Or number at current index
            // is smaller than number in the stack top
            while(!stack.isEmpty() && nums[i] <= nums[stack.peek()] ) {
                // We remove the index of stack top
                // For the number at that index first smaller element to the right
                // is current number indicated by index i
                firstSmallerToRight[stack.poll()] = nums[i];
            }

            // If we come here then number at index i is greater than
            // stack.top
            if (!stack.isEmpty()) {
                firstSmallerToLeft[i] = nums[stack.peek()];
            }
            // We are putting index as opposed to actual value.
            // From index we can retrieve the number
            stack.push(i);
        }
    }

    private void buildDecreasingStack() {
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                firstLargerToRight[stack.poll()] = nums[i];
            }
            if (!stack.isEmpty()) {
                firstLargerToLeft[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
    }

    public int[] getFirstSmallerToLeft() {
        return firstSmallerToLeft;
    }

    public int[] getFirstSmallerToRight() {
        return firstSmallerToRight;
    }

    public int[] getFirstLargerToLeft() {
        return firstLargerToLeft;
    }

    public int[] getFirstLargerToRight() {
        return firstLargerToRight;
    }

    public static void main(String[] args) {
        int[] nums = {8, 6, 4, 5, 7};
        MonotonicStack monotonicStack = new MonotonicStack(nums);
        System.out.println("FirstSmaller to left: " +
                Arrays.toString(monotonicStack.getFirstSmallerToLeft()));
        System.out.println("FirstSmaller to Right: " +
                Arrays.toString(monotonicStack.getFirstSmallerToRight()));
        System.out.println("FirstLarger to left: " +
                Arrays.toString(monotonicStack.getFirstLargerToLeft()));
        System.out.println("FirstLarger to right: " +
                Arrays.toString(monotonicStack.getFirstLargerToRight()));
    }
}

