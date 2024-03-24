package com.educative.io.pattern.o9treebfs;

import com.neetcode.beginners.algods.o11trees.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach.
The only difference will be, instead of keeping track of all the nodes in a level, we will only track the
depth of the tree. As soon as we find our first leaf node, that level will represent the minimum depth of the tree.
 */
// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

public class O6_MinimumDepthBinaryTree_111 {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        return minDepthBFS(root);
        // return minDepthDFS(root);
    }

    public static int minDepthBFS(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            minDepth = minDepth + 1;

            for (int i = 0; i < queueLength; i++) {
                TreeNode current = queue.poll();

                // Check if this is the leaf node
                if (current.left == null && current.right == null) {
                    return minDepth;
                }
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return minDepth;
    }

    public static int minDepthDFS(TreeNode root) {
        if (root == null) {
            // Return max value other than 0 otherwise overall answer will be 0.
            return Integer.MAX_VALUE;
        }

        int leftH = minDepthDFS(root.left);
        int rightH = minDepthDFS(root.right);

        if (leftH == Integer.MAX_VALUE && rightH == Integer.MAX_VALUE) {
            return 1;
        } else {
            return 1 + Math.min(leftH, rightH);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        int result = minDepth(root);
        System.out.println(result); // 3
    }
}
