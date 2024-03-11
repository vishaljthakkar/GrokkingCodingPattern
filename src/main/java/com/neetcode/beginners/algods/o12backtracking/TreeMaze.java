package com.neetcode.beginners.algods.o12backtracking;

import java.util.ArrayList;
import java.util.List;

public class TreeMaze {

    // Given a root node see if we can reach the left without hitting a node with value 0
    public static boolean canReachLeaf(TreeNode root) {
        // If the node is null or has 0 value
        if (root == null || root.val == 0) return false;

        // If the node is a leaf node.
        if (root.left == null && root.right == null) return true;

        // recursively check left subtree and right subtree
        if (canReachLeaf(root.left)) {
            return true;
        }
        if (canReachLeaf(root.right)) {
            return true;
        }
        return false;
    }

    // Same as above problem, but this time we have to return the path
    public static List<Integer> leafPath(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        helper(root, result);
        return result;
    }

    public static boolean helper(TreeNode root, List<Integer> result) {
        if (root == null || root.val == 0)
            return false;

        result.add(root.val);

        if (root.left == null && root.right == null) {
            return true;
        }
        if (helper(root.left, result)) {
            return true;
        }
        if (helper(root.right, result)) {
            return true;
        }
        result.remove(result.size() - 1);
        return false;
    }
}
