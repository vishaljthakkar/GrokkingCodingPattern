package com.needcode.advanced.algods.o1arrays.o4twopointers.leetcode;

// https://leetcode.com/problems/container-with-most-water/
public class O5_ContainerWithMostWater_11 {
    public static int maxArea(int[] height) {
        if (height.length == 0) return 0;

        int left = 0;
        int right = height.length - 1;
        int maxArea = -1;

        while(left < right) {
            int containerHeight = Math.min(height[left], height[right]);
            int area = containerHeight * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] <= height[right]) {
                left = left + 1;
            } else {
                right = right -1;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
    }
}
