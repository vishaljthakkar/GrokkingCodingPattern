package com.needcode.advanced.algods.o1arrays.o4twopointers.leetcode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class O3_RemoveDuplicatesSortedArray_26 {
    /* Logic here is the following:
       1. Peg the write index at 1 and iterate i = [1, n)
       2. if element at write index and i are different write the element at i at write index
       else they are same. do not write and decrement len.
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 1;

        int writerIndex = 1;
        for(int readerIndex = 1; readerIndex < nums.length; readerIndex++) {
            if (nums[readerIndex] != nums[readerIndex - 1]) {
                nums[writerIndex] = nums[readerIndex];
                writerIndex++;
            }
        }
        return writerIndex;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1, 2}));
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }

}
