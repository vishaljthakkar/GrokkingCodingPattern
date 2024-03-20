package com.educative.io.pattern.o3monotonicstack.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/next-greater-element-ii/
public class O4_NextGreaterElementII_503 {

    // https://www.youtube.com/watch?v=m4hvxzLoN_I&feature=emb_logo
    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int[] result = new int[nums.length];
        // This holds the default value if not updated. We need this.
        Arrays.fill(result, -1);

        // find the first greater element to the right.
        // Monotonically decreasing stack

        // Why 2 *len because array is circular
        // and we iterate in a circular fashion
        for(int i = 0; i < 2 * len; i++) {
           while(!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
               result[stack.pop() % len] = nums[i % len];
           }
           stack.push(i % len);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
        /*
        [2, -1, 2]
        [2, 3, 4, -1, 4]
         */
    }
}
