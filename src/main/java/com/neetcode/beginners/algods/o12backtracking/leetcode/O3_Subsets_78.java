package com.neetcode.beginners.algods.o12backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
// See the diagram in dropbox
public class O3_Subsets_78 {

    public static List<List<Integer>> subsets(int[] nums) {
//        return subSetsYesNoMethod(nums);
        return subSetsEulerTraversalMethod(nums);
    }

    public static List<List<Integer>> subSetsEulerTraversalMethod(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        List<Integer> partial = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;

        helper2(nums, result, partial, index);
        return result;
    }

    public static void helper2(int[] nums, List<List<Integer>> result, List<Integer> partial, int index) {
        // []
        // [1] -> [1, 2] -> [1, 2, 3]
        //     -> [1, 3]
        // [2] -> [2, 3]
        // [3]
        result.add(new ArrayList<>(partial)); // Start with empty set

        // DFS - Euler tree traversal from this index and see how much can you add to subset
        for(int i = index; i < nums.length; i++) {
            partial.add(nums[i]);
            // Note: This is not index + 1. Look at tree diagram in dropbox for why?
            // At this point I have considered i now I have to make decision on i + 1 in the next call.
            helper2(nums, result, partial, i + 1);
            // remove previously considered i and then move to i++
            partial.remove(partial.size() - 1); // backtrack before going to other branch.
        }
    }

    public static List<List<Integer>> subSetsYesNoMethod(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        List<Integer> partial = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;

        helper(nums, index, partial, result);
        return result;
    }

    public static void helper(int[] nums, int index, List<Integer> partial, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(partial));
            return;
        }
        // do not consider
        helper(nums, index + 1, partial, result);

        //consider
        partial.add(nums[index]);
        helper(nums, index + 1, partial, result);
        partial.remove(partial.size() -1);
    }

    public static void main(String[] args) {
//        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subSetsEulerTraversalMethod(new int[]{1, 2,3}));
        System.out.println(subSetsYesNoMethod(new int[]{1, 2,3}));
    }
}
