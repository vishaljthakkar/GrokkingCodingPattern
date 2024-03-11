package com.neetcode.beginners.algods.o12backtracking.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/description/
// See the diagram in dropbox
public class O4_SubsetsII_90 {


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        /*
            Very Important step to keep duplicate numbers close to each other
        */
        Arrays.sort(nums);

        List<Integer> partial = new ArrayList<>();
        int startIndex = 0;
        helper(nums, result, partial, startIndex);
        return result;
    }

    public static void helper(int[] nums, List<List<Integer>> result, List<Integer> partial, int index) {
        result.add(new ArrayList<>(partial));

        for(int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            partial.add(nums[i]);
            helper(nums, result, partial, i + 1);
            partial.remove(partial.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(subsetsWithDup(new int[]{4,4,4,1,4}));

    }
}
