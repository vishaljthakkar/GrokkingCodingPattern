package com.needcode.advanced.algods.o1arrays.o3slidingwindowvariable;

public class SlidingWindowVariableSize {
    // Find the length of longest subarray with the same
    // value in each position: O(n)
    public static int longestSubArray(int[] nums) {
        int length = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowStart] != nums[windowEnd]) {
                windowStart = windowEnd;
            }
            length = Math.max(windowEnd - windowStart + 1, length);
        }
        return length;
    }

    // Find length of minimum size subarray where the sum is
    // greater than or equal to the target: O(n)
    public static int shortestSubarray(int[] nums, int target) {
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum = windowSum + nums[windowEnd];

            while (windowSum >= target) {
                minLength = Math.min(windowEnd - windowStart + 1, minLength);
                windowSum = windowSum - nums[windowStart];
                windowStart = windowStart + 1;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }
}
