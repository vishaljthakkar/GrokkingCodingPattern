package com.neetcode.begineers.algods.staticarray.leetcode;

import java.util.Arrays;

public class O3_ShuffleArray_1470 {

    public static int[] shuffle(int[] nums, int n) {
        int [] result = new int[nums.length];

        int writerIndex = 0;
        for(int readerIndex1 = 0, readerIndex2 = n; readerIndex1 < n && readerIndex2 < 2 * n; readerIndex1++, readerIndex2++) {
            result[writerIndex++] = nums[readerIndex1];
            result[writerIndex++] = nums[readerIndex2];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2,5,1,3,4,7}, 3)));
        System.out.println(Arrays.toString(shuffle(new int[]{1,1,2,2}, 2)));
    }
}
