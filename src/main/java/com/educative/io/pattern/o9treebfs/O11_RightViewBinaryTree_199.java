package com.educative.io.pattern.o9treebfs;

// https://leetcode.com/problems/binary-tree-right-side-view/

import com.neetcode.beginners.algods.o11trees.leetcode.TreeNode;

import java.util.*;

public class O11_RightViewBinaryTree_199 {
    public static List<Integer> rightSideView(TreeNode root) {
        // This also takes 1ms
        // return rightSideViewStack(root);

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            if (current != null)
                result.add(current.val);
        }
        return result;
    }

    public static List<Integer> rightSideViewStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> partial = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                partial.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            stack.push(partial);
        }
        while (!stack.isEmpty()) {
            List<Integer> levelList = stack.pop();
            result.add(0, levelList.get(levelList.size() - 1));
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

        System.out.println(rightSideView(root));
        // [12, 1, 5, 17]
    }
}
