package com.neetcode.beginners.algods.o10binarysearch;

import com.educative.io.pattern.util.RandomArrayGenerator;

import java.util.Arrays;
import java.util.Random;

// https://leetcode.com/problems/binary-search/description/
public class BinarySearchTemplates {

    // First Template
    //  In the working case low and high both point to the single element. That is why the condition low <= high
    // Non working case, low crosses high so nothing is left to explore.
    public static int binarySearch1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Second template
    // In this both high and low in thd end point to the same element and breaks the loop.
    // high has 2 responsibility; either it is pointing to the target or is greater than target.

    public static int binarySearch2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[high] == target ? high : - 1;
    }

    // Template3
    // In this template, in the end we have 2 nodes to consider. low +1 < high makes sure we have 2 nodes in the end.
    public static int binarySearch3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
//            if (nums[mid] < target) {
            if (ok(nums, mid, target)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[low] != target && nums[high] != target) {
            return -1;
        }
        return nums[low] == target ? low : high;
    }

    public static boolean ok(int[] nums, int idx, int target) {
        return nums[idx] <= target;
    }

    public static boolean ok2(int[] nums, int idx, int target) {
        return nums[idx] >= target;
    }
    // Modified 3rd template
    // One pointer always points to the wrong element and the other always points to the possibly right element.
    // In the end, just confirm whether the pointer pointing to the possibly right element actually points to the right element.
    public static int binarySearch4(int[] nums, int target) {
        int low = -1;
        int high = nums.length - 1;

        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok2(nums, mid, target)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return nums[high] == target ? high : -1;
    }

    // Yet Another Template
    public static int binarySearch5(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        for(int jump = high / 2; jump >= 1; jump = jump / 2) {
            while(low + jump < high && nums[low + jump] <= target) {
                low = low + jump;
            }
        }
        if (nums[low] == target) {
            return low;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = new RandomArrayGenerator(10).setBound(100).getRandomIntArray();
        Arrays.sort(input1);
        int exist = input1[new Random().nextInt(input1.length)];
        int notExist = new Random().nextInt(200);

        System.out.println("Index of " + exist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch1(input1, exist));
        System.out.println("Index of " + notExist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch1(input1, notExist));
        System.out.println("Index of " + exist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch2(input1, exist));
        System.out.println("Index of " + notExist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch2(input1, notExist));
        System.out.println("Index of " + exist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch3(input1, exist));
        System.out.println("Index of " + notExist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch3(input1, notExist));
        System.out.println("Index of " + exist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch4(input1, exist));
        System.out.println("Index of " + notExist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch4(input1, notExist));
        System.out.println("Index of " + exist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch5(input1, exist));
        System.out.println("Index of " + notExist + " from Array: " + Arrays.toString(input1) + " is " +
                binarySearch5(input1, notExist));

    }
}
