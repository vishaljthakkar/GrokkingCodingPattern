package com.educative.io.pattern.o9treebfs;

import com.neetcode.beginners.algods.o11trees.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement
Given a binary tree and a node, find the level order successor of the given node in the tree.
The level order successor is the node that appears right after the given node in the level order traversal.

Solution
This problem follows the Binary Tree Level Order Traversal pattern. We can follow the same BFS approach.
The only difference will be that we will not keep track of all the levels.
Instead we will keep inserting child nodes to the queue. As soon as we find the given node,
we will return the next node from the queue as the level order successor.
 */
public class O9_LevelOrderSuccessor {

    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);

            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
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
        TreeNode node = findSuccessor(root, 12);
        System.out.println(node.val); // 7

        node = findSuccessor(root, 9);
        System.out.println(node.val); // 10
    }

}
