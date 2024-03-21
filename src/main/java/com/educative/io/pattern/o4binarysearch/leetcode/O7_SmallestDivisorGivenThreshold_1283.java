package com.educative.io.pattern.o4binarysearch.leetcode;

public class O7_SmallestDivisorGivenThreshold_1283 {

    public static int smallestDivisor(int[] nums, int threshold) {
        // Giving responsibility to high again.
        int low = 0;
        int high = (int) 1e6;

        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok(nums, mid, threshold)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    // Is sum of each 'num / mid' <= threshold?
    //  F F F F 'T' T T T T
    public static boolean ok(int[] nums, int mid, int threshold) {
        int result = 0;
        for(int num : nums) {
            int partial = Math.ceilDiv(num, mid);
            result = result + partial;
        }
        return result <= threshold;
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(smallestDivisor(new int[]{44,22,33,11,1}, 5));
        System.out.println(smallestDivisor(new int[]{21212,10101,12121}, 1000000));
    }
}
