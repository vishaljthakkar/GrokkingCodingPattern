package com.needcode.advanced.algods.o1arrays.o5prefixsum.leetcode;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/subarray-sum-equals-k/
// Check out editorial and https://www.youtube.com/watch?v=fFVZt-6sgyo
public class O5_SubArraySumEqualsKNegativeValues_560 {
    public static int subarraySum(int[] nums, int k) {
        return subArraySumHashMap(nums, k);
    }

    public static int subArraySumHashMap(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefixSum = 0, answer = 0;
        for(int num : nums) {
            prefixSum = prefixSum + num;
            answer = answer + count.getOrDefault(prefixSum - k, 0);
            count.put(prefixSum, count.getOrDefault(prefixSum, 0) + 1);
        }
        return answer;
    }

    public static int bruteForce(int[] nums, int k) {
        int count = 0;
        int sumSoFar = 0;

        if (nums == null || nums.length == 0)
            return count;

        for(int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            if (sumSoFar == k)
                count++;
            for(int j = i + 1; j < nums.length; j++) {
                sumSoFar += nums[j];
                if (sumSoFar == k)
                    count++;
            }
            sumSoFar = 0;
        }

        return count;
    }


    // This does not work. Why? because array contains negative values
    public static int slidingWindow(int[] nums, int k) {
        if (nums.length == 1 && k != nums[0]) return 0;

        int windowSum = 0;
        int windowStart = 0;
        int count = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum = windowSum + nums[windowEnd];

            if (windowSum >= k) {
                count = count + 1;
                windowSum = windowSum - nums[windowStart];
                windowStart = windowStart + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1 ,1}, 2));
        System.out.println(subarraySum(new int[]{1,2 ,3}, 3));
        System.out.println(subarraySum(new int[]{1}, 0));
        System.out.println(subarraySum(new int[]{-2, 1 , 2, -2, 5, -2, 1}, 3));

    }
}
