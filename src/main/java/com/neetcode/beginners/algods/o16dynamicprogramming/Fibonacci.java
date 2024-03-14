package com.neetcode.beginners.algods.o16dynamicprogramming;

public class Fibonacci {

    //Brute Force
    public static int bruteForce(int n) {
        if (n <= 1) {
            return n;
        }
        return bruteForce(n - 2) + bruteForce( n - 1);
    }

    // Memoization
    public static int memoization(int n, int[] cache) {
        if (n <= 1) return n;
        if (cache[n] != 0) return cache[n];

        cache[n] = memoization(n - 2, cache) + memoization(n - 1, cache);
        return cache[n];
    }

    // Dynamic Programming
    public static int dp(int n) {
        if (n <= 1) return n;

        // Here we do bottom up approach. 0->0 1->1 and we start the iteration with 2;
        int[] dp = new int[]{0, 1};
        int i = 2;

        // Since 2 is dependent on value at 0 and 1
        // we store the addition to index 1 and previous value of 1 is retained at index 0
        // to be used for next calculation.
        while(i <= n) {
            int tmp = dp[1];
            dp[1] = dp[0] + dp[1];
            dp[0] = tmp;
            i = i + 1;
        }
        return dp[1];
    }
}
