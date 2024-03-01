package com.pattern.slidingwindow;

import lombok.extern.slf4j.Slf4j;

/*
Q: Given an array, find the average of all contiguous subarrays of size 'K' in it
arr = [1,2,3,6,-1, 4,1,8,2] K - 5
 */
@Slf4j
public class AverageOfSubarrayOfSizeK {


    // Time Complexity O(N * K) N => arr.length
    public static double[] findAverageBF(int[] input, int K) {
        if (K <= 0 || K > input.length) {
            throw new IllegalArgumentException("subarray cannot be greater than array length");
        }
        double[] result = new double[input.length - K + 1];

        for(int i = 0; i <= input.length - K; i++) {
            double sum = 0;
            for(int j = i; j < i + K; j++) {
                sum += input[j];
            }
            result[i] = sum / K;
        }
        return result;
    }

    public static double[] findAverageSlidingWindow(int[] arr, int K) {
        if (K <= 0 || K > arr.length) {
            throw new IllegalArgumentException("Subarray K cannot be greater than arr array length");
        }
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            // add the next element
            windowSum += arr[windowEnd];

            // slide the window, we do not need to slide if we have not hit the required window of size K
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K; // calculate average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; //slide the window ahead
            }
        }
        return result;
    }
}
