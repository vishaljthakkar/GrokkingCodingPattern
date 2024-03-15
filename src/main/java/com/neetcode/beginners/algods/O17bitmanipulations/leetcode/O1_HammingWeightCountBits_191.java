package com.neetcode.beginners.algods.O17bitmanipulations.leetcode;
// https://leetcode.com/problems/number-of-1-bits/description/

public class O1_HammingWeightCountBits_191 {
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
        System.out.println(hammingWeight(2));
        System.out.println(hammingWeight(3));
        System.out.println(hammingWeight(4));
        System.out.println(hammingWeight(7));
        System.out.println(hammingWeight(8));
        System.out.println(hammingWeight(512));
        System.out.println(hammingWeight(1024));
    }
}
