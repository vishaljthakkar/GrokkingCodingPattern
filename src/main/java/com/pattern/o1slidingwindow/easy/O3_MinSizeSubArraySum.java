package com.pattern.o1slidingwindow.easy;

import com.pattern.util.RandomArrayGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/*
Given an array of positive numbers and a positive number 'S', find the length of the smallest contiguous subarray
whose sum is greater than or equal to 'S'. Return 0 if no such subarray exists.

Input: [2, 1, 5, 2, 3, 2] S = 7
Output: 2 [5, 2]

Input: [2, 1, 5, 2, 3, 2, 8] S = 7
Output: 1 [8]

Input: [3, 4, 1,1, 6], S= 8
Output: 3 [1, 1, 6]


Logic:

The problem follows the Sliding window pattern.
There is one difference though: In this problem, the size of the sliding window is not fixed.
1. First we will add up elements from the beginning of the array until their sum becomes greater than or equal to 'S'
2. These elements will constitute our sliding window. We are asked to find the smallest such window
having a sum greater than or equal to 'S'. We will remember the length of this window as the smallest window so far.
3. After this, we will keep adding one element in the sliding window, int a stepwise fashion.
4. In each step, we will also try to shrink the window from the beginning.
 We will shrink the window until the window's sum is smaller than 'S' again. This is needed as we intend to find the smallest window.
 This shrinking will also happen in multiple steps; in each step we do two things
 4.1 Check if the current window length is the smallest so far, and if so, remember its length.
 4.2 Subtract the first element of the window from the running sum to shrink the sliding window.
 */
@Slf4j
public class O3_MinSizeSubArraySum {

    /*
    Time complexity: O(n). outer for loop runs for all elements and inner while loop processes each element only once.
    O(n + n) => O(n)
     */
    public static int findMinSubArray(int S, int[] arr) {
        if (S <= 0) {
            throw new IllegalArgumentException("Sum or Array cannot be zero/Zero length");
        }
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while(windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void main(String[] args) {
        int[] input = new RandomArrayGenerator(10).setBound(5).getRandomIntArray();
        log.info("Input: " + Arrays.toString(input));
        log.info("Minimum length array: " + findMinSubArray(1, new int[]{}));
    }
}
