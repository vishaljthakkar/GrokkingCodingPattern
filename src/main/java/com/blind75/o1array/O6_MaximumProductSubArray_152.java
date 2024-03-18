package com.blind75.o1array;

// https://leetcode.com/problems/maximum-product-subarray/description/
// Search youtube for blind 75njava, you will get a good video.
// This one is the best explanation: https://www.youtube.com/watch?v=hnswaLJvr6g

public class O6_MaximumProductSubArray_152 {
    // https://leetcode.com/problems/maximum-product-subarray/description/
    // Search youtube for blind 75njava, you will get a good video.
    // This one is the best explanation: https://www.youtube.com/watch?v=hnswaLJvr6g
    public static int maxProduct(int[] nums) {
        return maxProductByObservationPrefixSuffixSum(nums);
        // return maxProductKadaneDP(nums);
    }

    // This is much intuitive
    public static int maxProductByObservationPrefixSuffixSum(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - 1 - i];
            answer = Math.max(answer, Math.max(prefix, suffix));
        }
        return answer;
    }

    // It is a good solution but to explain is very tricky.
    public static int maxProductKadaneDP(int[] nums) {
        int result = nums[0];
        int currentMin = 1;
        int currentMax = 1;

        for (int num : nums) {
            int tmp = currentMax * num;
            currentMax = Math.max(num, Math.max(tmp, currentMin * num));
            currentMin = Math.min(num, Math.min(tmp, currentMin * num));
            result = Math.max(result, currentMax);
        }
        return result;
    }
}
