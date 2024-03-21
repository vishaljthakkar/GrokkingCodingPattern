package com.educative.io.pattern.o4binarysearch.leetcode;

public class O6_FindMinimumInSortedArray_153 {
    public static int findMin(int[] nums) {
        // We are giving responsibility to high here.
        int low = -1;
        int high = nums.length - 1;

        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok(nums, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return nums[high];

    }

    // Is considered number less than or equal to the last number
    // 4 5 0 1 2 3
    //F F F 'T' T T T
    public static boolean ok(int[] nums, int mid) {
        // We can just do < because leetcode says numbers are unique
        // Also work you with number 12345 and keep rotating to see why adjacent comaprison will not yield result.
        return nums[mid] <= nums[nums.length - 1];
    }

    public static void main(String[] args) {
        // All the integers of nums are unique.
        int[] input = {3,4,5,1,2};
        System.out.println(findMin(input));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }
}
