package com.needcode.advanced.algods.o1arrays.o2slidingwindowfixed.leetcode;
// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
public class O2_NumSubArraySizeKAvgGreaterOrEqualToThreshold_1343 {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        return slidingWindow(arr, k, threshold);
    }

    public static int slidingWindow(int[] arr, int k, int threshold) {
        int count = 0;
        int windowStart = 0;
        int windowSum = 0;
        double windowAvg = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum = windowSum + arr[windowEnd];

            if (windowEnd - windowStart + 1 >= k) {
                windowAvg = windowSum / k;
                if (windowAvg >= threshold) {
                    count = count + 1;
                }
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }
        return count;
    }

    public static int bruteForce(int[] arr, int k, int threshold) {
        int count = 0;

        for(int i = 0; i < Math.min(arr.length, arr.length - k + 1); i++) {
            int sum = 0;
            double currentAvg = 0;
            for(int j = i; j < i + k; j++) {
                sum = sum + arr[j];
            }
            currentAvg = sum / k;
            if (currentAvg >= threshold) {
                count = count + 1;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
        System.out.println(numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5));
    }
}
