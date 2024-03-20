package com.educative.io.pattern.o3monotonicstack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class O7_LargestRectangleHistogram_84 {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        // Monotonic increasing stack
        // Find the next smallest number to my right.
        // Once you find that next smallest number to the right, calculate the area of all the rectangles that we can form
        // from this smallest right index going left just before the smallest index on the left
        for(int i = 0; i <= heights.length; i++) {
            while(!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = (!stack.isEmpty()) ? i - stack.peek() - 1 : i;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    // Brute Force Solution. Works but hits TLE.
    public static int largestRectangleAreaBF(int[] heights) {
        int minHeight = Integer.MAX_VALUE;
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++) {
            minHeight = heights[i];
            for(int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
                // System.out.println(maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{2, 4}));
    }
}
