package com.needcode.advanced.algods.o1arrays.o4twopointers.leetcode;

// https://leetcode.com/problems/trapping-rain-water/
public class O6_TrappingRainWater_42 {
    // previous submission and https://www.youtube.com/watch?v=ZI2z5pq0TqA
    public int trap(int[] height) {
        return trapExtraSpace(height);
        // return trapNoExtraSpace(height);
    }

    public static int trapExtraSpace(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        /* LeftMax and rightMax holds the values tallest buildings on its left and right in 2 separate array */

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        /* 2 corner buildings */
        leftMax[0] = height[0];
        rightMax[rightMax.length - 1] = height[height.length - 1];

        // Find the leftMax for every ith location
        for(int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // Find the rightMax for every ith location
        for(int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        /* Water is bounded by minimum of  max left height building and max right height building.
           and of course minus the building height as water is on top not the structure itself.
        */
        int water = 0;
        for(int i = 0; i < height.length; i++) {
            water = water + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }

    public static int trapNoExtraSpace(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int result = 0;
        while(left < right) {
            if(leftMax < rightMax) {
                left = left + 1;
                leftMax = Math.max(leftMax, height[left]);
                result = result + (leftMax - height[left]);
            } else {
                right = right - 1;
                rightMax = Math.max(rightMax, height[right]);
                result = result + (rightMax - height[right]);
            }
        }
        return result;
    }
}
