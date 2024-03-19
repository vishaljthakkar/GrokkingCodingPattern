package com.educative.io.pattern.o2twopointer.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an array with positive numbers and a target number, find all of its contiguous subarrays
whose product is less than the target number.

Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.

Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.


This problem follows the Sliding Window and the Two Pointers pattern and shares similarities with
Triplets with Smaller Sum with two differences:
1. In this problem, the input array is not sorted.
2. Instead of finding triplets with sum less than a target, we need to find all subarrays having a
product less than the target.
 */
// https://leetcode.com/problems/subarray-product-less-than-k/
public class O9_SubArrayWithProductLessThanTarget {

    public static List<List<Integer>> findSubArrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1;
        int left = 0; // windowStart
        int count = 0;  //Leetcode question needs only count.

        // right = windowEnd
        for (int right = 0; right < arr.length; right++) {
            product = product * arr[right];

            while (product >= target && left < arr.length) {
                product = product / arr[left];
                left = left + 1;
            }

            // Since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from left to right will have the product less than  the target too;
            // to avoid duplicates, we will  start with a subarray containing  only arr[right] and then
            // extend it to the left
            // NOTE: This is very nice trick.
            count = count + right - left + 1; // leet code asks for count then just return the count
            List<Integer> partial = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                partial.add(0, arr[i]);
                result.add(new ArrayList<>(partial));
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubArrays(new int[]{2, 5, 3, 10}, 30));
        System.out.println(findSubArrays(new int[]{10, 5, 2, 6}, 100));
    }
}
