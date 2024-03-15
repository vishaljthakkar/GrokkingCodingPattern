package com.neetcode.beginners.algods.O17bitmanipulations.leetcode;

public class O3_ReverseBits_190 {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int output = 0;

        for(int i = 0; i < 32; i++) {
            output <<= 1;
            output |= n & 1;
            n >>= 1;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(123));
    }
}
