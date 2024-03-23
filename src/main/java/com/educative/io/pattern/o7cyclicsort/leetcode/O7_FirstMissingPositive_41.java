package com.educative.io.pattern.o7cyclicsort.leetcode;
/*
Solution:
This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing Number with
one big difference. In this problem, the numbers are not bound by any range so we can have any number
in the input array.

However, we will follow a similar approach though as discussed in Find the Missing Number to place the
numbers on their correct indices and ignore all numbers that are out of the range of the array
(i.e., all negative numbers and all numbers greater than or equal to the length of the array).

Once we are done with the cyclic sort we will iterate the array and the first index that does not have the
correct number will be the smallest missing positive number!
 */

// https://leetcode.com/problems/first-missing-positive/description/
public class O7_FirstMissingPositive_41 {

    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0  && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i = i + 1;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 0};
        System.out.println(firstMissingPositive(input)); // 3
        input = new int[]{3, 4, -1, 1};
        System.out.println(firstMissingPositive(input)); // 2
        input = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(input)); // 1
        input = new int[]{1};
        System.out.println(firstMissingPositive(input)); // 2. This is the last return nums.length + 1;
    }

}
