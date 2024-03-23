package com.educative.io.pattern.o7cyclicsort.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
This problem follows the Cyclic Sort pattern and shares similarities with Find the Duplicate Number.
Following a similar approach, we will place each number at its correct index. After that, we will
iterate through the array to find all numbers that are not at the correct indices. All these numbers
are duplicates.
 */
// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
public class O5_FindAllDuplicatesInAnArray_442 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
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
                result.add(nums[i]);
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
        int[] input = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(input));
        input = new int[]{1, 1, 2};
        System.out.println(findDuplicates(input));
        System.out.println(findDuplicates(new int[]{1}));
    }
}
