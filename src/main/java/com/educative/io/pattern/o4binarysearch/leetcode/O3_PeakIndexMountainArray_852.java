package com.educative.io.pattern.o4binarysearch.leetcode;

public class O3_PeakIndexMountainArray_852 {
    public static int peakIndexInMountainArray(int[] arr) {
        // Giving responsibility to low. pointing to possibly right element
        int low = 0;
        // high pointing to wrong element
        int high = arr.length;

        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok(arr, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Question to ask for low to move:
    // Is my number is greater than one before it
    // T T T T 'T' F F F F
    public static boolean ok(int[] arr, int index) {
        return arr[index] > arr[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] {0, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[] {0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray(new int[] {0, 10, 5, 2}));
    }
}
