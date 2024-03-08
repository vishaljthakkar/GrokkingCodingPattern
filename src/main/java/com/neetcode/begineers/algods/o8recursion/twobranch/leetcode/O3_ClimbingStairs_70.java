package com.neetcode.begineers.algods.o8recursion.twobranch.leetcode;

import java.util.HashMap;

public class O3_ClimbingStairs_70 {

    static HashMap<Integer, Integer> lookup = new HashMap<>();

    public static int climbStairs(int n) {
        if (lookup.containsKey(n)) {
            return lookup.get(n);
        }

        // There is only one way to climb step 1 and one way to remain/climb on step 0
        // This is the base case like fibonacci
        if (n <= 1) {
            lookup.put(n, 1);
            return 1;
        }

        lookup.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return lookup.get(n);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
