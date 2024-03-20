package com.educative.io.pattern.o3monotonicstack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/132-pattern/description/
public class O6_132Pattern_456 {
    // In this problem we have to find following pattern
    // i < j < k nums[i] < nums[k] < nums[j]
    // i j and k need not be consecutive.
    // 3 1 4 2 => 1 < 4 < 2

    // we will start from right and find the first larger element to the left.
    // Monotonically decreasing stack
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for(int i = nums.length - 1; i >=0; i--) {
            while(!stack.isEmpty() && nums[i] > stack.peek()) {
                max = stack.pop();
            }
            if (nums[i] > max) {
                stack.push(nums[i]); // maxValue goes to the stack
            } else if (nums[i] < max) {
                return true;
            }
        }
        return false;

    }
}
