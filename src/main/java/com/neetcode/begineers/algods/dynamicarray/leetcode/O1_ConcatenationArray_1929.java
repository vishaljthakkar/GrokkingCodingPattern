package com.neetcode.begineers.algods.dynamicarray.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/concatenation-of-array/
public class O1_ConcatenationArray_1929 {

    public static int[] getConcatenation(int[] nums) {
        int[] result = new int[2 * nums.length];

        int writerIndex = 0;
        for(int readerIndex = 0; readerIndex < nums.length; readerIndex++) {
            result[writerIndex] = nums[readerIndex];
            result[writerIndex + nums.length] = nums[readerIndex];
            writerIndex++;
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(getConcatenation(new int[]{1,3,2,1})));
        System.out.println(Arrays.toString(getConcatenation(new int[]{1})));
    }
}
