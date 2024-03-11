package com.neetcode.beginners.algods.o12backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/description/
public class O5_CombinationSum_39 {
    // See dropbox for diagram
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) return result;

        int startIndex = 0;
        List<Integer> partial = new ArrayList<>();
        helper(candidates, target, result, partial, startIndex);
        return result;
    }

    public static void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> partial, int startIndex) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(partial));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            partial.add(candidates[i]);
            // Keep trying same index "i" until we find an answer or hit error case
            helper(candidates, target - candidates[i], result, partial, i);
            partial.remove(partial.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum(new int[]{2}, 1));
    }
}
