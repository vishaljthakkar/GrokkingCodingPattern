package com.educative.io.pattern.o2twopointer.medium;

import java.util.Arrays;

/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
Write a function to return the count of such triplets.

Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

Input: [-1, 4, 2, 1, 3], target=5
Output: 4
Explanation: There are four triplets whose sum is less than the target:
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]

This problem follows the Two Pointers pattern and shares similarities with Triplet Sum to Zero.
The only difference is that, in this problem, we need to find the triplets whose sum is less than the given target.
To meet the condition i != j != k we need to make sure that each number is not used more than once.

Following a similar approach, first we can sort the array and then iterate through it, taking one number at a time.
Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X+Y+Z < target
At this stage, our problem translates into finding a pair whose sum is less than "target -X"
We can use a similar approach as discussed in Triplet Sum to Zero.

Time Complexity
Sorting  => O(nlogn)
for loop over a number array and for each number looping over the array from both ends
O(N^2).
Asymptotically => O(n^2)

Space Complexity
O(N)
 */
public class O7_TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int count = 0;

        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2 ; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    public static int searchPair(int[] arr, int target, int first) {
        int count = 0;
        int left = first + 1; int right = arr.length - 1;

        while(left < right) {
            int currentSum = arr[left] + arr[right];
            // found the triplet meeting the condition
            if (currentSum < target) {
                // Given that array is sorted
                // arr[right] >= arr[left], therefore, we can replace arr[right] by any number that comes between
                // right and left
                count += right - left;
                left++;
            } else {
                right --; // we need a pair with smaller number
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
