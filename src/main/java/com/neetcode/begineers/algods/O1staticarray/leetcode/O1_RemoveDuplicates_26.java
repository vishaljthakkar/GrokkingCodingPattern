package com.neetcode.begineers.algods.O1staticarray.leetcode;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

 */
public class O1_RemoveDuplicates_26 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 1)
            return -1;

        int readerIndex = 1, writerIndex = 1;
        while(readerIndex < nums.length) {
            if (nums[readerIndex]  != nums[readerIndex - 1]) {
                nums[writerIndex] = nums[readerIndex];
                readerIndex++;
                writerIndex++;
            } else {
                readerIndex++;
            }
        }
        return writerIndex;
    }


    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 1)
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
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicates2(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
