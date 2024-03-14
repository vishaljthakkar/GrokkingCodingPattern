package com.neetcode.beginners.algods.o16dynamicprogramming.leetcode;

// https://leetcode.com/problems/climbing-stairs/description/

import java.util.HashMap;
import java.util.Map;

public class O1_ClimbingStairs_70 {
    static Map<Integer, Integer> cache = new HashMap<>();

    public static int climbStairs(int n) {
        return climbStairsMemoization(n);
    }

    public static int climbStairsMemoization(int n) {
        if (n <= 1) {
            cache.put(1, 1);
            return 1;
        }

        if (cache.containsKey(n)) return cache.get(n);

        cache.put(n, climbStairsMemoization(n - 1) + climbStairsMemoization(n - 2));

        return cache.get(n);
    }


    public static int dynamicProgramming(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[2];
        dp[0] = 1; // There is one way to climb 0 stairs. Just Stay there.
        dp[1] = 1; // There is one way to climb 1 stairs. Take one step.

        // Start with 2 stairs. We know that to climb 2 stairs we need to take 1 step or 2 step
        // That is we have to know how to climb stairs (2 - 1) and stairs (2 - 2).
        // Since that base case is already calculated, we can build solution from them like fibonacci
        int i = 2;
        while(i <= n) {
            int tmp = dp[1];
            dp[1] = dp[0] + dp[1];
            dp[0] = tmp;
            i = i + 1;
        }

        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(dynamicProgramming(2));
    }
}
