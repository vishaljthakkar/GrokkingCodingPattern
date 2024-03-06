package com.pattern.O2twopointer.medium;

import java.util.Arrays;

/*
Given an array of unsorted numbers and a target number, find a triplet in the array whose
sum is as close to the target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.

Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.


This problem follows the Two Pointers pattern and is quite similar to Triplet Sum to Zero.
We can follow a similar approach to iterate through the array,
taking one number at a time. At every step, we will save the difference between the triplet and the target number, so that in the end, we can return the triplet with the closest sum.

 */
public class O6_TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while(left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find the target difference
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                // we have found the triplet with exact sum
                if (targetDiff == 0) {
                    // return the sum of all the numbers
                    return targetSum - targetDiff;
                }

                // the second part of the above 'if' is to handle the smallest sum when we have more than one
                // answer
                if (Math.abs(targetDiff) < Math.abs(smallestDifference) ||
                Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference) {
                    smallestDifference = targetDiff; // save the closest and the biggest difference
                }

                if (targetDiff > 0)
                    left++; // we need a triplet with bigger sum
                else
                    right--; // we need a triplet with smaller sum
            }
        }
        return targetSum - smallestDifference;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        System.out.println(searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        System.out.println(searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}
