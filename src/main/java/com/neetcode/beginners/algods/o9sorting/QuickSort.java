package com.neetcode.beginners.algods.o9sorting;

import java.util.Arrays;

// https://leetcode.com/problems/sort-an-array/description/

public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {
        // base case
        if (low >= high)
            return;

        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, high);
    }

    public static int partition(int[] nums, int low, int high) {
        int pivotIndex = high;
        int pivotValue = nums[pivotIndex];

        int writerIndex = low;
        for(int readerIndex = low; readerIndex < high; readerIndex++) {
            // You want to move readerIndex to find the value which
            // is lower than pivotValue. Once you find the value
            // lower than pivotValue swap it with the writerIndex
            if (nums[readerIndex] < pivotValue) {
                swap(nums, readerIndex, writerIndex);
                writerIndex++;
            }
        }

        // Above writerIndex movement has made sure that numbers
        // left of writerIndex are smaller than pivot.
        // Lets swap writerIndex value with pivotIndexValue
        swap(nums, pivotIndex, writerIndex);
        pivotIndex = writerIndex;

        return pivotIndex;
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        int[] input = new int[]{5, 2, 3, 1};
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
