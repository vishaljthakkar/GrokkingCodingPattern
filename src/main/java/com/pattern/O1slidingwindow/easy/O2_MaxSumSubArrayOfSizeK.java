package com.pattern.O1slidingwindow.easy;

import com.pattern.util.RandomArrayGenerator;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

/*
Given an array of positive numbers and a positive number 'k',
find the maximum sum of any contiguous subarray of size 'k

Input: [2, 1, 5, 1, 3, 2], k = 3
Output: 9 given by array [5, 1, 3]

Input: [2, 3, 4, 1, 5], k = 2
Output: 7 by array [3, 4]
 */
@Slf4j
public class O2_MaxSumSubArrayOfSizeK {

    // Time complexity: O(N * K)
    public static int findMaxSumSubArrayBF(int[] arr, int k) {
        Instant start = Instant.now();
        int maxSum = 0;
        for(int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for(int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        Instant end = Instant.now();
        log.info("Time elapsed BT: " + Duration.between(start, end).toNanos() + " nanoseconds");
        return maxSum;
    }


    public static int findMaxSumSubArraySW(int[] arr, int k) {
        Instant start = Instant.now();
        if (k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("K should be larger than input array length");
        }

        int maxSum = 0;
        int windowStart = 0;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        Instant end = Instant.now();
        log.info("Time elapsed SW: " + Duration.between(start, end).toNanos() + " nanoseconds");
        return maxSum;
    }

    public static void main(String[] args) {
//        System.out.println(findMaxSumSubArrayBF(new int[]{2,1, 5, 1, 3, 2}, 3));
//        System.out.println(findMaxSumSubArrayBF(new int[]{2, 3, 4, 1, 5}, 2));
//        System.out.println(findMaxSumSubArraySW(new int[]{2,1, 5, 1, 3, 2}, 3));
//        System.out.println(findMaxSumSubArraySW(new int[]{2, 3, 4, 1, 5}, 2));

        System.out.println("Brute Force: " + findMaxSumSubArrayBF(new RandomArrayGenerator(100000).getRandomIntArray(), 10));
        System.out.println("Sliding Window: " +findMaxSumSubArraySW(new RandomArrayGenerator(100000).getRandomIntArray(), 10));
    }
}
