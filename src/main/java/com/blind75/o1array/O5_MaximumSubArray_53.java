package com.blind75.o1array;

// https://leetcode.com/problems/maximum-subarray/
public class O5_MaximumSubArray_53 {
    public static int maxSubArray(int[] nums) {
        // return kadane(nums);
        return slidingWindow(nums);
    }

    public static int kadane(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0];

        for(int i = 0; i < nums.length; i++) {
            currentSum = Math.max(currentSum, 0);
            currentSum = currentSum + nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    // This method is pretty much same as above. Only difference is we can
    // also find the indexes of the subarray
    public static int slidingWindow(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0];
        int windowStart = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (currentSum < 0) {
                currentSum = 0;
                windowStart = windowEnd;
            }
            currentSum = currentSum + nums[windowEnd];


            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLeft = windowStart; // index of the start of the subarray
                maxRight = windowEnd; // index of the end of the subarray
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
