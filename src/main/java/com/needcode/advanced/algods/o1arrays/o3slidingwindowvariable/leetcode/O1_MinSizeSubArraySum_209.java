package com.needcode.advanced.algods.o1arrays.o3slidingwindowvariable.leetcode;
// https://leetcode.com/problems/minimum-size-subarray-sum/

public class O1_MinSizeSubArraySum_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum = windowSum + nums[windowEnd];

            while(windowSum >= target) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum = windowSum - nums[windowStart];
                windowStart = windowStart + 1;
            }
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen( 7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen( 4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen( 11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
