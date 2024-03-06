package com.pattern.O2twopointer.easy;
/*
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
after removing the duplicates in-place return the new length of the array.

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].

Time Complexity
O(N)

Space Complexity
O(1)
 */
public class O2_RemoveDuplicates {

    public static int remove(int[] arr) {
        int len = arr.length;
        int writeIndex = 1;
        for(int i = 1; i < arr.length; i++) {
            if (arr[writeIndex - 1] != arr[i]) {
                arr[writeIndex] = arr[i];
                writeIndex += 1;
            } else {
                len -= 1;
            }
        }
        return writeIndex;

    }
    public static void main(String[] args) {
        System.out.println(remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
        System.out.println(remove(new int[]{2, 2, 2, 11}));

    }
}
