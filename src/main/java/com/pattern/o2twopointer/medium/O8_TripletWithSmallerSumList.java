package com.pattern.o2twopointer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Same as problem O7_TripletWithSmallerSum
Problem: Write a function to return the list of all such triplets instead of the count.
How will the time complexity change in this case?
 */
public class O8_TripletWithSmallerSumList {

    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            searchPair(arr, target - arr[i], i, result);
        }
        return result;
    }

    public static void searchPair(int[] arr, int target, int index, List<List<Integer>> result) {
        int left = index + 1;
        int right = arr.length - 1;

        while(left < right) {
            int currentSum = arr[left] + arr[right];
            // found the triplet
            if (currentSum < target) {
                // Given that array is sorted
                // arr[right] >= arr[left], therefore, we can replace arr[right] by any number that comes between
                // right and left
                for(int i = right; i > left; i--) {
                    result.add(Arrays.asList(arr[index], arr[left], arr[i]));
                }
                left++;
            } else
                right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
