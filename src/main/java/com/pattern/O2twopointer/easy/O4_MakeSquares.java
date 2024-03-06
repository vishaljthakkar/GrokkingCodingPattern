package com.pattern.O2twopointer.easy;

import java.util.Arrays;

/*
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]

Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]

Time Complexity

O(N) as we are iterating over an array only once.

Space Complexity
O(N) to store the result.
 */
public class O4_MakeSquares {


    public static int[] makeSquares(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int left = 0, right = arr.length - 1;
        int[] result = new int[arr.length];
        int resultWriteIndex = arr.length - 1;

        while(left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                result[resultWriteIndex] = leftSquare;
                resultWriteIndex--;
                left++;
            } else {
                result[resultWriteIndex] = rightSquare;
                resultWriteIndex--;
                right--;
            }
        }
        return result;
    }
    public static int[] makeSquaresNotWorking(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int left = 0, right = arr.length - 1;
        int resultIndex = 0;
        int[] result = new int[arr.length];

        // This does not work as I am comparing 2 ends and filling the result.
        // It will not give sorted result
        while(left <= right) {
            if (Math.abs(arr[left]) < Math.abs(arr[right])) {
                result[resultIndex] = arr[left] * arr[left];
                left++;
                resultIndex++;
            } else if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                result[resultIndex] = arr[right] * arr[right];
                right--;
                resultIndex++;
            } else {
                result[resultIndex] = arr[left] * arr[left];
                left++; right--;
                resultIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(makeSquares(new int[]{-2, -1, 0, 2, 3})));
        System.out.println(Arrays.toString(makeSquares(new int[]{-3, -1, 0, 1, 2})));

    }
}
