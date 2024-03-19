package com.educative.io.pattern.o2twopointer.problemchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal
to the target number

Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.


Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.

This problem follows the Two Pointers pattern and shares similarities with Triplet Sum to Zero.

We can follow a similar approach to iterate through the array, taking one number at a time.
At every step during the iteration, we will search for the quadruplets similar to Triplet Sum to Zero whose
sum is equal to the given target.
// https://leetcode.com/problems/4sum/description/

 */
public class O1_QuadrupleSumToTarget {
    public static List<List<Integer>> searchQuadruple(int[] nums, int target) {
        // Because we have to find unique quadruplets
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 3; i++) {
            // skip same elements to avoid duplicate quadruplets
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for(int j = i + 1; j < nums.length - 2; j++) {
                // skip same elements to avoid duplicate quadruplets
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                searchPairs(nums, target, i, j, result);
            }
        }
        return result;
    }

    public static void searchPairs(int[] nums, int targetSum, int first, int second, List<List<Integer>> result) {
        int left = second + 1;
        int right = nums.length - 1;

        while(left < right) {
            // sum is long because integer overflow can occur.
            // Added long to the first number so that result is long
            long sum = (long)nums[first] + nums[second] + nums[left] + nums[right];
            if (sum == targetSum) { //found the answer
                result.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));
                left = left + 1;
                right = right - 1;
                while(left < right && nums[left] == nums[left - 1]) {
                    // skip to avoid duplicates
                    left = left + 1;
                }
                while(left < right && nums[right] == nums[right + 1]) {
                    // skip to avoid duplicates
                    right = right - 1;
                }
            } else if (sum < targetSum) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(searchQuadruple(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9));
        System.out.println(searchQuadruple(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
}
