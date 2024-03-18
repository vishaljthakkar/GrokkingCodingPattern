package com.blind75.o1array;

// https://leetcode.com/problems/product-of-array-except-self/description/
// https://www.youtube.com/watch?v=bNvIQI2wAjk

import java.util.Arrays;

public class O4_ProductOfArrayExceptSelf_238 {
    public static int[] productExceptSelf(int[] nums) {
        // return productExceptSelfExtraSpace(nums);
        return productExceptSelfNoExtraSpace(nums);
    }

    // Core logic here is that for every cell location we are calculating
    // prefix multiplication and post fix multiplication excluding current cell.
    public static int[] productExceptSelfNoExtraSpace(int[] nums) {
        int[] result = new int[nums.length];

        int right = 1, left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left = left * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        return result;

    }

    public static int[] productExceptSelfExtraSpace(int[] nums) {
        int len = nums.length;

        int[] leftPrefixProduct = new int[len];
        int[] rightPostfixProduct = new int[len];
        int[] result = new int[len];

        int leftPrefix = 1; // Nothing before start of the array then just take 1.
        for(int i = 0; i < len; i++) {
            leftPrefixProduct[i] = leftPrefix * nums[i];
            leftPrefix = leftPrefixProduct[i];
        }

        int rightPostfix = 1; // Nothing after the end of the array then just take 1.
        for(int j = len - 1; j >= 0; j--) {
            rightPostfixProduct[j] = rightPostfix * nums[j];
            rightPostfix = rightPostfixProduct[j];
        }

        for(int i = 0; i < len; i++) {
            if (i == 0) {
                result[i] = rightPostfixProduct[i + 1];
            } else if (i == len - 1) {
                result[i] = leftPrefixProduct[i - 1];
            } else {
                result[i] = leftPrefixProduct[i - 1] * rightPostfixProduct[i + 1];
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1,2,3,4};
        int[] input2 = new int[]{-1,1,0,-3,3};

        System.out.println(Arrays.toString(productExceptSelfNoExtraSpace(input1)));
        System.out.println(Arrays.toString(productExceptSelfExtraSpace(input1)));

        System.out.println(Arrays.toString(productExceptSelfNoExtraSpace(input2)));
        System.out.println(Arrays.toString(productExceptSelfExtraSpace(input2)));
    }

}
