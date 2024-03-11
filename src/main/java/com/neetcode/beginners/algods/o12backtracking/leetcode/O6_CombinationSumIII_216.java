package com.neetcode.beginners.algods.o12backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class O6_CombinationSumIII_216 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> partial = new ArrayList<>();

        int[] nums = new int[9];
        for(int i = 0; i < 9; i++) {
            nums[i] = i + 1;
        }
        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        // Using IntStream slows down the execution.
        // int[] nums = IntStream.range(1, 9 + 1).toArray();
        int startIndex = 0;
        helper(k, n, nums, partial, result, startIndex);
        return result;
    }

    public static void helper(int k, int targetSum, int[] nums, List<Integer> partial,
                       List<List<Integer>> result, int startIndex) {

        if (partial.size() == k && targetSum == 0) {
            // result.add(new ArrayList<>(partial));
            result.add(List.copyOf(partial));
            return;
        }

        // Return if we overshoot k combination of number or targetSum becomes negative
        if (partial.size() > k || targetSum < 0) return;


        for(int i = startIndex; i < nums.length; i++) {
            partial.add(nums[i]);
            int subsum = targetSum - nums[i];

            helper(k, subsum, nums, partial, result, i + 1);

            partial.remove(partial.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 1));
        System.out.println(combinationSum3(2, 18));
    }
}
