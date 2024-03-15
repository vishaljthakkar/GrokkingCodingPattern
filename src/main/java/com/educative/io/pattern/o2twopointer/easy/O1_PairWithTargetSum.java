package com.educative.io.pattern.o2twopointer.easy;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11

Time Complexity
The time complexity of the above algorithm will be O(N) where ‘N’ is the total number of elements in the given array.

Space Complexity
O(1)
 */
public class O1_PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        if (arr.length == 0)
            throw new IllegalArgumentException();

        int left = 0, right = arr.length - 1;

        while(left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum)
                return new int[] {left, right};

            if (currentSum < targetSum)
                left = left + 1; // we need pair with bigger sum
            else
                right = right - 1; // we need pair with smaller sum
        }
        return new int[] {-1, -1};
    }

    // Space Complexity: O(N)
    public static int[] searchHT(int[] arr, int targetSum) {
        // to store numbers and their indices
        var nums = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i])) {
                return new int[]{nums.get(targetSum - arr[i]), i};
            } else {
                nums.put(arr[i], i); // put the number and its index in the map
            }
        }
        return new int[]{-1, -1};

    }


        public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[]{1, 2, 3, 4, 6}, 6)));
        System.out.println(Arrays.toString(search(new int[]{2, 5, 9, 11}, 11)));
        System.out.println(Arrays.toString(searchHT(new int[]{1, 2, 3, 4, 6}, 6)));
        System.out.println(Arrays.toString(searchHT(new int[]{2, 5, 9, 11}, 11)));
    }
}
