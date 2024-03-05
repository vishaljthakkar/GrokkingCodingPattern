package com.pattern.o1slidingwindow.hard;

import java.util.Arrays;

/*
Given an array containing 0's and 1's, if you are allowed to replace no more than 'k' 0s  with 1s, find the length of the
longest contiguous subarray having all 1s

Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.

 */
public class O8_ReplacingOnes {


    public static int findLength(int[] arr, int k) {
        int windowStart = 0, maxOnesCount = 0, maxLength = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1)
                maxOnesCount += 1;

            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart] == 1)
                    maxOnesCount -= 1;
                windowStart += 1;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
    public static int findLength2(int[] arr, int k) {
        int windowStart = 0, maxOnesCount = 0, maxLength = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1)
                maxOnesCount += 1;

            if (windowEnd - windowStart + 1 - maxOnesCount <= k) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            } else {
                if (arr[windowStart] == 1)
                    maxOnesCount -= 1;
                windowStart += 1;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] input1 = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println("longest contiguous subarray having all 1s Input: " + Arrays.toString(input1) + " => "
                + findLength(input1, 2));
        int[] input2 = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println("longest contiguous subarray having all 1s Input: " + Arrays.toString(input2) + " => "
                + findLength(input2, 3));
    }
}
