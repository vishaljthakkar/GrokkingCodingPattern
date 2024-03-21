package com.educative.io.pattern.o4binarysearch.leetcode;

public class O9_CapacityToShipPackagesWithinDDays_1011 {
    public static int shipWithinDays(int[] weights, int days) {
        int low = -1;
        // Giving responsibility to high
        int high = (int) (500 * 5e4); // constraint from the question.

        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok(weights, mid, days)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    // Can we ship all the packages within time if each ship can carry 'mid' weight
    // F F F F F 'T' T T T T
    public static boolean ok(int[] weights, int shipCapacity, int days) {
        int requiredDays = 1;
        int current =  0;

        for(int weight : weights) {
            // if a single weight of the package itself is bigger than overall capacity, then we cannot ship.
            if (weight > shipCapacity) {
                return false; // low move ahead.
            }
            if (current + weight > shipCapacity) {
                requiredDays = requiredDays + 1;
                // reset current because we exceeded ship capacity for a day.
                current = 0;
            }
            current = current + weight;
        }
        // I took less days to ship all the packages. Maybe my ship capacity is too high. Decrease high
        // OR return false if requiredDays is more that means my ship capacity is too low. Increase low
        // At one point during debugging 16 also gave 5 days. But this <= made high point to mid to find
        // next lower capacity which is 15 for the same 5 days.
        return requiredDays <= days;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }
}
