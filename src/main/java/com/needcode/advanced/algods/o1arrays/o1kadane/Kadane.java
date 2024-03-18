package com.needcode.advanced.algods.o1arrays.o1kadane;

import java.util.Arrays;

// Find a non empty subarray with the largest sum
// array: 4 -1 2 -7 3 4
// Answer = 7
public class Kadane {

    // O(n^2)
    public static int bruteForce(int[] nums) {
        int maxSum = nums[0];

        for(int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for(int j = i; j < nums.length; j++) {
                currentSum = currentSum + nums[j];
                maxSum = Math.max(currentSum, maxSum);
            }
        }
        return maxSum;
    }

    // Kadane's Algorithm: O(n)
    public static int kadane(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for(int num : nums) {
            currentSum = Math.max(currentSum, 0);
            currentSum = currentSum + num;
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    // Return the left and right index of the max subarray sum
    // assuming there is exactly one result [no ties]
    // Sliding window variation of kadanes: O(n)

    public static int[] slidingWindow(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        int maxLeftIndex = 0;
        int maxRightIndex = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (currentSum < 0) {
                currentSum = 0;
                windowStart = windowEnd;
            }
            currentSum = currentSum + nums[windowEnd];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLeftIndex = windowStart;
                maxRightIndex = windowEnd;
            }
        }
        return new int[]{maxLeftIndex, maxRightIndex, currentSum};
    }

    public static void main(String[] args) {
        System.out.println(kadane(new int[]{4, -1, 2, -7, 3, 4}));
        System.out.println(Arrays.toString(slidingWindow(new int[]{4, -1, 2, -7, 3, 4})));
    }
}
