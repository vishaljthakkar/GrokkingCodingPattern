package com.educative.io.pattern.o9treebfs;

import com.neetcode.beginners.algods.o11trees.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O3_ZigZagLevelOrderTraversal_103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // For first iteration it is left to right
        boolean rightToLeft = false;

        while(!queue.isEmpty()) {
            int queueLength = queue.size();
            List<Integer> partial = new ArrayList<>();
            for(int i = 0; i < queueLength; i++) {
                TreeNode current = queue.poll();

                if (rightToLeft) {
                    partial.add(0, current.val);
                } else {
                    partial.add(current.val);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(new ArrayList<>(partial));
            rightToLeft = !rightToLeft;
        }
        return result;
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
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);
        // [[12], [1, 7], [9, 10, 5], [17, 20]]
    }
}
