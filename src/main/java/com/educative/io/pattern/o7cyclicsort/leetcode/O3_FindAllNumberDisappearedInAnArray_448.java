package com.educative.io.pattern.o7cyclicsort.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing Number
with one difference. In this problem, there can be many duplicates whereas in ‘Find the Missing Number’
there were no duplicates and the range was greater than the length of the array.

However, we will follow a similar approach though as discussed in Find the Missing Number to
place the numbers on their correct indices. Once we are done with the cyclic sort we will iterate
the array to find all indices that are missing the correct numbers.
 */
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
public class O3_FindAllNumberDisappearedInAnArray_448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i = i + 1;
            }
        }

        for(i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
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
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));// [5, 6]
        System.out.println(findDisappearedNumbers(new int[]{2, 3, 1, 8, 2, 3, 5, 1})); // [4, 6, 7]
    }
}
