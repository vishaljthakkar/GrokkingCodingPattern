package com.educative.io.pattern.o9treebfs;

import com.neetcode.beginners.algods.o11trees.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O5_LargestValueInEachRow_515 {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int queueLength = queue.size();
            int maxAtThisLevel = Integer.MIN_VALUE;
            for(int i = 0; i < queueLength; i++) {
                TreeNode current = queue.poll();
                maxAtThisLevel = Math.max(maxAtThisLevel, current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            result.add(maxAtThisLevel);
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
        List<Integer> result = largestValues(root);
        System.out.println(result);
        // [12.0, 4.0, 8.0, 18.5]
    }
}
