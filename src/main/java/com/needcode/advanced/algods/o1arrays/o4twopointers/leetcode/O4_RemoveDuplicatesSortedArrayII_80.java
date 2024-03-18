package com.needcode.advanced.algods.o1arrays.o4twopointers.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
// https://www.youtube.com/watch?v=ycAq8iqh0TI
public class O4_RemoveDuplicatesSortedArrayII_80 {
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;

        while(right < nums.length) {
            int count = 1;
            while((right + 1 < nums.length) && (nums[right] == nums[right + 1])) {
                right = right + 1;
                count = count + 1;
            }
            for(int i = 0; i < Math.min(2, count); i++) {
                nums[left] = nums[right];
                left = left + 1;
            }
            right = right + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
