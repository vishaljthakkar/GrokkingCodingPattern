package com.educative.io.pattern.o3monotonicstack.leetcode;

import java.util.*;

// https://leetcode.com/problems/next-greater-element-i/submissions/404111164/

public class O3_NextGreaterElementI_496 {

    // https://www.youtube.com/watch?v=m4hvxzLoN_I&feature=emb_logo
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        int[] result = new int[nums1.length];
        Arrays.fill(result, - 1);

        // Find the next greater element to the right in nums2. Monotonically decreasing stack
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                nextGreater.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        for(int i = 0; i < nums1.length; i++) {
            if (nextGreater.containsKey(nums1[i])) {
                result[i] = nextGreater.get(nums1[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
