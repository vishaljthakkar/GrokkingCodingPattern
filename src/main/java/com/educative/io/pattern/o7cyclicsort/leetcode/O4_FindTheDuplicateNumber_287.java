package com.educative.io.pattern.o7cyclicsort.leetcode;
/*
This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing Number.
Following a similar approach, we will try to place each number on its correct index.
Since there is only one duplicate, if while swapping the number with its index both the numbers
being swapped are same, we have found our duplicate!


 */
// https://leetcode.com/problems/find-the-duplicate-number/description/
public class O4_FindTheDuplicateNumber_287 {

    public static int findDuplicate(int[] nums) {
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
                return nums[i];
            }
        }
        return -1;
    }

    public static int findNumberEducative(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else { // we have found the duplicate
                    return nums[i];
                }
            } else {
                i = i + 1;
            }
        }
        return - 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2})); // 2
        System.out.println(findDuplicate(new int[]{3,1,3,4,2})); // 3
        System.out.println(findDuplicate(new int[]{3,3,3,3,3})); // 3
        System.out.println(findNumberEducative(new int[]{1, 3, 4, 2, 2})); // 2
        System.out.println(findNumberEducative(new int[]{3,1,3,4,2})); // 3
        System.out.println(findNumberEducative(new int[]{3,3,3,3,3})); // 3
    }
}
