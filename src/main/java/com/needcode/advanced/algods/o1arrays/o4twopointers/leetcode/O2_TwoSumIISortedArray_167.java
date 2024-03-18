package com.needcode.advanced.algods.o1arrays.o4twopointers.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class O2_TwoSumIISortedArray_167 {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;

        while(left < right) {
            int numLeft = numbers[left];
            int numRight = numbers[right];

            if (numLeft + numRight > target) {
                right = right - 1;
            } else if (numLeft + numRight < target) {
                left = left + 1;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }
}
