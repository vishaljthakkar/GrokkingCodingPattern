package com.neetcode.beginners.algods.O17bitmanipulations.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/counting-bits/
public class O2_CountingBitsArray_338 {
    // 0 1 2 3 4 5 6 7 => num
    // 1 1 1 2 1 2 2 3
    /* See discussion for alternate approach as well */
    public  static int[] countBits(int num) {
        if (num == 0) return new int[]{0};

        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;


        for(int i = 2; i <= num; i++) {
            result[i] = result[i % 2] + result[i / 2];
        }
        return result;
    }

    public static int[] countBitsAlternate(int n) {
        int[] result = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            result[i] = hammingWeight(i);
        }
        return result;
    }

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
        System.out.println(Arrays.toString(countBits(1)));
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits(3)));
        System.out.println(Arrays.toString(countBits(4)));
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println(Arrays.toString(countBits(6)));
        System.out.println(Arrays.toString(countBits(7)));
    }
}
