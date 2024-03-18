package com.needcode.advanced.algods.o1arrays.o1kadane.leetcode;

// https://leetcode.com/problems/maximum-sum-circular-subarray/description/
public class O2_MaximumSumCircularSubArray_918 {

    public static int maxSubarraySumCircular(int[] nums) {
        return kadane(nums);
    }

    /*
    The idea here similar to kadane problem #53 maxsumsubarray.
    We are calculating maxSum named it as globalMax but we also are trying to find minSumSubArray.
    This will give us subarray that has minimum sum. Then we are subtracting total sum of the array with this minimum sum.
    This will take in to account circular array as num[0] and num[length - 1 ] is also part of the total array.
    Then we compare if globalMax is greater than this totalSum - globalMin. If yes, then that is the answer otherwise
    regular kadane logic that gave us globalmax is the answer
    */
    public static int kadane(int[] nums) {
        int currentMax = 0,  currentMin = 0;
        int globalMax = nums[0], globalMin = nums[0];
        int totalSum = 0;

        for(int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            currentMin = Math.min(num, currentMin + num);
            totalSum = totalSum + num;
            globalMax = Math.max(currentMax, globalMax);
            globalMin = Math.min(currentMin, globalMin);
        }
        return globalMax > 0 ? Math.max(globalMax, totalSum - globalMin) : globalMax;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }
}
