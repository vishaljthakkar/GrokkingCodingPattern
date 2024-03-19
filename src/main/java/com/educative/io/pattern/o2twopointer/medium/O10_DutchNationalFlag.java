package com.educative.io.pattern.o2twopointer.medium;

import java.util.Arrays;

/*
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists
of three different numbers that is why it is called Dutch National Flag problem.

Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]

Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]

The brute force solution will be to use an in-place sorting algorithm like Heapsort which will take O(nlogn).
Can we do better than this? Is it possible to sort the array in one iteration?

We can use a Two Pointers approach while iterating through the array. Let’s say the two pointers are called low and high
which are pointing to the first and the last element of the array respectively. So while iterating, we will move all 0s
before low and all 2s after high so that in the end, all 1s will be between low and high.

 */
// https://leetcode.com/problems/sort-colors/description/
public class O10_DutchNationalFlag {

    public static void sort(int[] nums) {
        // all elements to the left of low are 0.
        // all elements to the right of high are 2.
        // all elements from >= low and < i are 1
        int low = 0;
        int high = nums.length - 1;


        int i = 0;
        while(i < high ) {                  // 0. [1 (i, low), 0, 2, 1, 0 (high)]
            if (nums[i] == 0) {             // 2. [0, 1 (low), 2 (i), 1, 0 (high)]
                swap(nums, i, low);         // 4 [0, 0, 1 (low), 1 (i)(high), 2]
                i++;
                low++;
            } else if (nums[i] == 1) {      // 1. [1 (low), 0 (i), 2, 1, 0 (high)]
                i++;
            } else {                        // 3. [0, 1(low), 0 (i), 1 (high), 2]
                // reason being the one you swapped could be 0 or 1. We will let next loop decide
                swap(nums, i, high);
                high--;
            }
        }
    }

    public static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        // This example tells you why you need i <= high
        int[] input1 = new int[]{2, 0 , 1};
        sort(input1);
        System.out.println(Arrays.toString(input1));

    }
}
