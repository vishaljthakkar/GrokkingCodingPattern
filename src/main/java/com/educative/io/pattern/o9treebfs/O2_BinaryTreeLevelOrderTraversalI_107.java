package com.educative.io.pattern.o9treebfs;


import com.neetcode.beginners.algods.o11trees.leetcode.TreeNode;

import java.util.*;

public class O2_BinaryTreeLevelOrderTraversalI_107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
//        Stack<List<Integer>> stack = new Stack();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int queueLength = queue.size();
            List<Integer> partial = new ArrayList<>();
            for(int i = 0; i < queueLength; i++) {
                TreeNode current = queue.poll();
                partial.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(0, new ArrayList<>(partial));
//            stack.push(new ArrayList<>(partial));
        }
//
//        while(!stack.isEmpty()) {
//            result.add(stack.pop());
//        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = levelOrderBottom(root);
        System.out.println(result);
        // [[9, 10, 5], [7, 1], [12]]
    }
}
