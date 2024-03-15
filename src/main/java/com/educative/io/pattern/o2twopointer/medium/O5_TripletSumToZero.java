package com.educative.io.pattern.o2twopointer.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.

This problem follows the Two Pointers pattern and shares similarities with Pair with Target Sum.
A couple of differences are that the input array is not sorted and instead of a pair we need to
find triplets with a target sum of zero.

To follow a similar approach, first, we will sort the array and then iterate through it
taking one number at a time. Let’s say during our iteration we are at number ‘X’,
so we need to find ‘Y’ and ‘Z’ such that X+Y+Z == 0. At this stage, our problem translates into
finding a pair whose sum is equal to "-X" As Y+Z = -X

Another difference from Pair with Target Sum is that we need to find all the unique triplets.
To handle this, we have to skip any duplicate number.
Since we will be sorting the array, so all the duplicate numbers will be next to each other
and are easier to skip.

Time Complexity
Sorting the array will take O(nlogn).
The search pair function will take O(n).
As we are calling search pair for everynumber in input array, this means that overall run time
will be O(n logn + n^2) which is asymptotically O(n^2)

Space Complexity
O(N) for storing the result

Sorting the array
 */
public class O5_TripletSumToZero {
    public static List<List<Integer>> searchTriplet(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException();
        }

        List<List<Integer>> result = new ArrayList<>();
        // This is to make sure duplicates are together so that we can skip
        // to get unique elements.
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i -1])
                continue;
            searchPairTargetSum(arr, -1 * arr[i], i + 1, result);
        }
        return result;
    }

    public static void searchPairTargetSum(int[] arr, int targetSum, int left, List<List<Integer>> result) {
        int right = arr.length - 1;
        while(left < right) {
            int currentSum = arr[left] + arr[right];
            // found the triplet
            if (currentSum == targetSum) {
                result.add(Arrays.asList(-1 * targetSum, arr[left], arr[right]));
                left++; right--;

                // skip same element to avoid duplicate triplets
                while(left < right && arr[left] == arr[left - 1])
                    left++;
                // skip same element to avoid duplicate triplets
                while(left < right && arr[right] == arr[right + 1])
                    right--;
            } else if (currentSum < targetSum) {
                left++;
            } else {
                right --;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(searchTriplet(new int[]{-5, 2, -1, -2, 3}));
    }
}
