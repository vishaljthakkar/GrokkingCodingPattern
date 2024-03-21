package com.educative.io.pattern.o4binarysearch.leetcode;

import java.util.Arrays;

// https://www.youtube.com/watch?v=WVsezzbgXxc
public class O1_FindFirstAndLastPositionOfElementSortedArray_34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums.length == 0) return result;

        int right = searchRightTemplate4(nums, target);
        int left = searchLeftTemplate4(nums, target);
        System.out.println("Template4: [" + left + "," + right + "]");

        right = searchRightTemplate3(nums, target);
        left = searchLeftTemplate3(nums, target);

        result[0] = left;
        result[1] = right;
        return result;
    }

    /* In the searchRight low is given the responsibility, so low will point to possibly right element and high will point to wrong element.
    In the searchLeft high is given the responsibility, so high will point to possibly right element and low will point to wrong element.
    */

    public static int searchRightTemplate4(int[] nums, int target) {
        int low = 0;
        // Why not nums.length -1 like in a template.
        // Reason is this scenario [7,7,7,7,7,7]
        // low will point to index 4 and mid will always be calculated as 4.
        // since we are giving responsibility for low to move right
        // we need to bias our mid calculation to move to the right.
        // In the above scenario mid will always be 4 and not reach 5 if
        // high is nums.length - 1;
        int high = nums.length;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (rightOk(nums, mid, target)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return (nums[low] == target) ? low : -1;
    }

    public static boolean rightOk(int[] nums, int index, int target) {
        return nums[index] <= target;
    }

    public static int searchLeftTemplate4(int[] nums, int target) {
        int low = -1;

        int high = nums.length - 1;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (leftOk(nums, mid, target)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return (nums[high] == target) ? high : -1;
    }

    public static boolean leftOk(int[] nums, int index, int target) {
        return nums[index] >= target;
    }


    // This is the same logic but with extra check for both low and high
    // In this too when we are searching right low is given responsibility and high is
    // given responsibility when we are searching left.
    // But since low and high are one distance apart low + 1 < high
    //we need to check high index first when we are searching right
    // and low first when we are searching left
    public static int searchRightTemplate3(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (rightOkTemplate3(nums, mid, target)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (nums[hi] == target) {
            return hi;
        } else if (nums[lo] == target) {
            return lo;
        } else {
            return -1;
        }
    }

    public static boolean rightOkTemplate3(int[] nums, int mid, int target) {
        return nums[mid] <= target;
    }

    public static int searchLeftTemplate3(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (leftOkTemplate3(nums, mid, target)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (nums[lo] == target) {
            return lo;
        } else if (nums[hi] == target) {
            return hi;
        } else {
            return -1;
        }
    }

    public static boolean leftOkTemplate3(int[] nums, int mid, int target) {
        return nums[mid] >= target;
    }

    public static void main(String[] args) {
        int[] input1 = {5,7,7,8,8,10};
        int[] input2 = {};
        int[] input3 = {1};

        System.out.println(Arrays.toString(searchRange(input1, 8)));
        System.out.println(Arrays.toString(searchRange(input1, 6)));
        System.out.println(Arrays.toString(searchRange(input2, 0)));
        System.out.println(Arrays.toString(searchRange(input3, 0)));
        /*  Template4: [3,4]
            [3, 4]
            Template4: [-1,-1]
            [-1, -1]
            [-1, -1]
            Template4: [-1,-1]
            [-1, -1]
         */
    }
}
