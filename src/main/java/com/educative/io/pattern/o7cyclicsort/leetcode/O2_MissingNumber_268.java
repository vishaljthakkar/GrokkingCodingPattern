package com.educative.io.pattern.o7cyclicsort.leetcode;
/*
This problem follows the Cyclic Sort pattern. Since the input array contains unique numbers from the
range 0 to ‘n’, we can use a similar strategy as discussed in Cyclic Sort to place the numbers on
their correct index. Once we have every number in its correct place, we can iterate the array to
find the index which does not have the correct number, and that index will be our missing number.
However, there are two differences with Cyclic Sort:

1. In this problem, the numbers are ranged from ‘0’ to ‘n’, compared to ‘1’ to ‘n’ in the Cyclic Sort.
   This will make two changes in our algorithm:
     - In this problem, each number should be equal to its index, compared to index + 1 in the Cyclic Sort.
       Therefore => nums[i] == nums[nums[i]]
     - Since the array will have ‘n’ numbers, which means array indices will range from 0 to ‘n-1’.
       Therefore, we will ignore the number ‘n’ as we can’t place it in the array,
       so => nums[i] < nums.length
2. Say we are at index i. If we swap the number at index i to place it at the correct index,
   we can still have the wrong number at index i. This was true in Cyclic Sort too. It didn’t cause any
   problems in Cyclic Sort as over there, we made sure to place one number at its correct place in each step,
   but that wouldn’t be enough in this problem as we have one extra number due to the larger range.
   Therefore, we will not move to the next number after the swap until we have a correct number at the index i.
 */
// https://leetcode.com/problems/missing-number/description/
public class O2_MissingNumber_268 {
    public static int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i = i + 1;
            }
        }

        // find the first number missing from its index, that will be our required number
        for(i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1})); // 2
        System.out.println(missingNumber(new int[]{0, 1})); // 2
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8
    }
}
