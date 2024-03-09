package com.neetcode.beginners.algods.o9sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

// https://leetcode.com/problems/sort-an-array/description/
public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        Instant startTime = Instant.now();
        // first element, 0th, is always sorted. So we start the loop from 1st element
        for(int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while(j >= 0 && arr[j] > arr[j+1]) {
                int temp = arr[j + 1];
                arr[j+ 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        Instant endTime = Instant.now();
        System.out.println("Time taken by Insertion Sort: " + Duration.between(startTime, endTime).toMillis());
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{4, 1, 3, 6, 7, 2})));
    }
}
