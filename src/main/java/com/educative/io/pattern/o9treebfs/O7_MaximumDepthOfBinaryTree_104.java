package com.educative.io.pattern.o9treebfs;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/

import com.neetcode.beginners.algods.o11trees.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class O7_MaximumDepthOfBinaryTree_104 {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // return maxDepthDFS(root);
        return maxDepthBFS(root);
    }

    public static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            maxDepth = maxDepth + 1;

            for (int i = 0; i < queueLength; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return maxDepth;
    }

    public static int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;

        int leftH = maxDepthDFS(root.left);
        int rightH = maxDepthDFS(root.right);
        return 1 + Math.max(leftH, rightH);
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
        int result = maxDepth(root);
        System.out.println(result); // 4
    }
}
