package com.educative.io.pattern.o7cyclicsort.leetcode;

import java.util.Arrays;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally
contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which
also resulted in one number going missing. Find both these numbers.

Solution:
This problem follows the Cyclic Sort pattern and shares similarities with Find all Duplicate Numbers.
Following a similar approach, we will place each number at its correct index.
Once we are done with the cyclic sort, we will iterate through the array to find the number that
is not at the correct index. Since only one number got corrupted, the number at the wrong index
is the duplicated number and the index itself represents the missing number.
 */
public class O6_FindTheCorruptPair {
    public static int[] findDuplicateAndMissing(int[] nums) {
        int[] result = new int[]{-1, -1};
        int  i = 0;
        while( i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i = i + 1;
            }
        }

        // Find the duplicate number
        for(i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result[0] = nums[i];
                result[1] = i + 1;
            }
        }
        return result;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 2, 5,2};
        System.out.println(Arrays.toString(findDuplicateAndMissing(input)));
        input = new int[]{3, 1, 2, 3, 6, 4};
        System.out.println(Arrays.toString(findDuplicateAndMissing(input)));
    }
}
