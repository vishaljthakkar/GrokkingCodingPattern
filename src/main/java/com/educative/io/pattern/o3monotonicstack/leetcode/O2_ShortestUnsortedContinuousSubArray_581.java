package com.educative.io.pattern.o3monotonicstack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
We know that in a sorted array we will always have
increasing value. But given input has a subarray that is not sorted and
does not adhere to always increasing number. Which means there will be
smaller number at an arbitrary index than the number at previous index.

This means we have to find the firstSmallestNumber to the right when going
from left to right. For this we will use Monotonic Stack with increasing order

Now from right to left we have to find the first largest number to the left
For this we will use Monotonic stack with decreasing order


There is 2 pointer method to solve this question as well. Check out 2 pointer pattern.
 */
// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class O2_ShortestUnsortedContinuousSubArray_581 {


    public int findUnsortedSubArray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int left = nums.length;
        int right = 0;

        // Find the first value from left which is incorrect.
        // Find the first small number to the right
        // We have to build increasing Monotonic stack
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        // clear the stack before re use
        stack.clear();

        // Find the first value from right which is not correct
        // Monotonically decreasing stack
        for(int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }
}
