package com.blind75.o1array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/description/
public class O1_TwoSum_01 {
    /* 1. Brute force approach
        Dual for loop. Outer loop will take the number at index i and inner loop will search for
        target - i O(N^2)

        Another approach would be make a copy of the array and then sort it.
        After sorting iterate with i do binary search for target - i. If found store the pair.
        Go back to original array and find the indexes of the pair element and return the result.
     */
    public static int[] twoSumBT(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> lookup = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(lookup.containsKey(target - nums[i])) {
                result[0] = lookup.get(target - nums[i]);
                result[1] = i;
                break;
            }
            lookup.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumBT(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSumBT(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSumBT(new int[]{3, 3}, 6)));

        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));


    }
}
