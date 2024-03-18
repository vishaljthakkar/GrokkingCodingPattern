package com.needcode.advanced.algods.o1arrays.o4twopointers;

public class TwoPointer {

    // Given a string of characters, return true if it's a palindrome,
    // return false otherwise: O(n)
    public static boolean isPalindrome(String word) {
        if (word == null || word.isEmpty()) return true;

        int left = 0;
        int right = word.length() -1;

        while(left < right) {
            if (word.charAt(left) != word.charAt(right))
                return false;

            left = left + 1;
            right = right -1;
        }
        return true;
    }

    //  Given a sorted array of integers, return the indices
    //  of two elements (in different positions) that sum up to
    //  the target value. Assume there is exactly one solution.
    //  O(n)
    public static int[] targetSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            if (nums[left] + nums[right] > target) {
                right = right - 1;
            } else if (nums[left] + nums[right] < target) {
                left = left + 1;
            } else {
                return new int[]{left, right};
            }
        }
        return null;
    }
}
