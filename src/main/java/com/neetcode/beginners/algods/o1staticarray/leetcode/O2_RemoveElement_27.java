package com.neetcode.beginners.algods.o1staticarray.leetcode;

// https://leetcode.com/problems/remove-element/
public class O2_RemoveElement_27 {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;

        int writerIndex = 0;
        for(int readerIndex = 0; readerIndex < nums.length; readerIndex++) {
            if (nums[readerIndex] != val) {
                nums[writerIndex] = nums[readerIndex];
                writerIndex++;
            }
        }
        return writerIndex;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

}
