package com.neetcode.begineers.algods.o8recursion.twobranch.leetcode;

import java.util.HashMap;

// https://leetcode.com/problems/fibonacci-number/description/
public class O1_Fibonacci_509 {

    static HashMap<Integer, Integer> lookup = new HashMap<>();

    // Base case: n = 0 or 1
    public static int fibonacci(int n) {
        if (lookup.containsKey(n)) {
            return lookup.get(n);
        }
        if (n <= 1) {
            lookup.put(n, n);
            return n;
        }

        // Recursive case: fib(n) = fib(n - 1) + fib(n - 1)
        lookup.put(n , fibonacci(n - 1) + fibonacci(n - 2));
        return lookup.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
