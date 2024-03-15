package com.neetcode.beginners.algods.o9sorting;

import com.educative.io.pattern.util.RandomArrayGenerator;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

// https://leetcode.com/problems/sort-an-array/description/

public class MergeSort {

    public static void mergeSort(int[] nums, int start, int end) {

        if (end <= start) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, mid + 1, end);

    }

    public static void merge(int[] nums, int leftArrLow, int leftArrHigh, int rightArrLow, int rightArrHigh) {

//        if (leftArrLow == rightArrHigh)
//            return;

        int[] mergeArray = new int[leftArrHigh - leftArrLow + 1 + rightArrHigh - rightArrLow + 1];
        int mergeArrayLow = leftArrLow;
        int mergeArrayHigh = rightArrHigh;

        int index = 0;

        while(leftArrLow <= leftArrHigh && rightArrLow <= rightArrHigh) {
            mergeArray[index++] = nums[leftArrLow] < nums[rightArrLow] ? nums[leftArrLow++] : nums[rightArrLow++];
        }

        while(leftArrLow <= leftArrHigh)
            mergeArray[index++] = nums[leftArrLow++];

        while(rightArrLow <= rightArrHigh)
            mergeArray[index++] = nums[rightArrLow++];

        //write back to original array. reset index
        index = 0;
        while(mergeArrayLow <= mergeArrayHigh) {
            nums[mergeArrayLow++] = mergeArray[index++];
        }
    }

    public static void main(String[] args) {
        int[] randomIntArray = new RandomArrayGenerator(1_000).setBound(1_00).getRandomIntArray();
//        System.out.println(Arrays.toString(InsertionSort.insertionSort(randomIntArray)));

        Instant startTime = Instant.now();

        mergeSort(randomIntArray, 0, randomIntArray.length - 1);
        System.out.println(Arrays.toString(randomIntArray));
        Instant endTime = Instant.now();
        System.out.println("Time taken by Merge Sort: " + Duration.between(startTime, endTime).toMillis());
    }
}
