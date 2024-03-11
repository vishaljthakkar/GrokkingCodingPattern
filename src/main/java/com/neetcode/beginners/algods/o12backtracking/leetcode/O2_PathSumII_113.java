package com.neetcode.beginners.algods.o12backtracking.leetcode;

import com.neetcode.beginners.algods.o12backtracking.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/

public class O2_PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Integer> partial = new ArrayList<>();
        helper(root, targetSum, result, partial);
        return result;
    }

    public void helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> partial) {
        if (root == null) return;

        if (root.left == null && root.right == null && root.val == targetSum) {
            partial.add(root.val);
            result.add(new ArrayList<>(partial));
            partial.remove(partial.size() - 1);
            return;
        }

        partial.add(root.val);
        helper(root.left, targetSum - root.val, result, partial);

        helper(root.right, targetSum - root.val, result, partial);
        partial.remove(partial.size() - 1);
    }
}
