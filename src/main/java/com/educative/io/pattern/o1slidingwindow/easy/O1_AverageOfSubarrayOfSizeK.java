package com.educative.io.pattern.o1slidingwindow.easy;

import com.educative.io.pattern.util.RandomArrayGenerator;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/*
Q: Given an array, find the average of all contiguous subarrays of size 'K' in it
arr = [1,2,3,6,-1, 4,1,8,2] K - 5
 */
@Slf4j
public class O1_AverageOfSubarrayOfSizeK {


    // Time Complexity O(N * K) N => arr.length
    public static double[] findAverageBF(int[] input, int K) {
        Instant start = Instant.now();
        if (K <= 0 || K > input.length) {
            throw new IllegalArgumentException("subarray cannot be greater than array length");
        }
        double[] result = new double[input.length - K + 1];

        for(int i = 0; i < input.length - K + 1; i++) {
            double sum = 0;
            for(int j = i; j < i + K; j++) {
                sum += input[j];
            }
            result[i] = sum / K;
        }
        Instant end = Instant.now();
        log.info("Time elapsed: " + Duration.between(start, end).toNanos() + " nanoseconds");
        return result;
    }

    // Time complexity O(n)
    public static double[] findAverageSlidingWindow(int[] arr, int K) {
        Instant start = Instant.now();
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
        Instant end = Instant.now();
        log.info("Time elapsed: " + Duration.between(start, end).toNanos() + " nanoseconds");
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        System.out.println(Arrays.toString(findAverageBF(arr, 5)));
        System.out.println(Arrays.toString(findAverageSlidingWindow(arr, 5)));

        findAverageBF(new RandomArrayGenerator(10000).getRandomIntArray(), 5);
        findAverageSlidingWindow(new RandomArrayGenerator(10000).getRandomIntArray(), 5);
    }
}
