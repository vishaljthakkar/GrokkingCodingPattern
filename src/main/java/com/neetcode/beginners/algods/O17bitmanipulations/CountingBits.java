package com.neetcode.beginners.algods.O17bitmanipulations;

public class CountingBits {

    public static void operations() {
        // AND
        int n = 1 & 1;

        // OR
        n = 1 | 0;

        // XOR
        n = 0 ^ 1;

        // NOT (negation)
        n = ~n;

        // Bit Shifting
        n = 1;
        n = n << 1;
        n = n >> 1;

        return;
    }

    public static int countBits(int n) {
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
        System.out.println(countBits(1));
        System.out.println(countBits(2));
        System.out.println(countBits(3));
        System.out.println(countBits(4));
        System.out.println(countBits(7));
        System.out.println(countBits(8));
        System.out.println(countBits(512));
        System.out.println(countBits(1024));
    }
}
