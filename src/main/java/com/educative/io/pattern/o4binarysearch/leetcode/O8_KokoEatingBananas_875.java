package com.educative.io.pattern.o4binarysearch.leetcode;

public class O8_KokoEatingBananas_875 {

    public static int minEatingSpeed(int[] piles, int h) {
        // He will not eat any banana
        int low = 0;
        // We are giving responsibility to high
        int high = (int) 1e9;

        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok(piles, mid, h)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    // Can koko eat all bananas in H hours with speed mid/hr
    // F F F F 'T' T T T T T
    public static boolean ok(int[] piles, int index, int hour) {
        // this can become negative for one of the inputs below. Make it long.
        long hoursTaken = 0;
        for(int bananas : piles) {
            hoursTaken += Math.ceilDiv(bananas, index);
        }
        return hoursTaken <= hour;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println(minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
        System.out.println(minEatingSpeed(new int[]{312884470}, 968709470));
        // 4
        // 30
        // 23
        // 3
        // 1
    }
}
