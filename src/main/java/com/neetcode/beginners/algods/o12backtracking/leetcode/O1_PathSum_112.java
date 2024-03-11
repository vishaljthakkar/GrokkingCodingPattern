package com.neetcode.beginners.algods.o12backtracking.leetcode;

import com.neetcode.beginners.algods.o12backtracking.TreeNode;

// https://leetcode.com/problems/path-sum/
public class O1_PathSum_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        if (hasPathSum(root.left, targetSum - root.val)) {
            return true;
        }
        if (hasPathSum(root.right, targetSum - root.val)) {
            return true;
        }
        return false;
    }
}
