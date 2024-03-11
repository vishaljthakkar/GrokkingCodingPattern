package com.neetcode.beginners.algods.o11trees.leetcode;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

public class O3_KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        // Solution in order of increasing runtime best to worst
        return usingStack(root, k);

        // return usingHeap(root, k);

        // List<Integer> result = new ArrayList<>();
        // usingListInOrder(root, result);
        // return result.get(k - 1);
    }

    public int usingStack(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
    }

    public int usingHeap(TreeNode root, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int result = -1;

        inOrderHelper(root, heap, k);

        while (!heap.isEmpty()) {
            result = heap.poll();
        }
        return result;
    }

    public void inOrderHelper(TreeNode root, PriorityQueue<Integer> heap, int k) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left, heap, k);
        if (heap.size() < k) {
            heap.offer(root.val);
        } else if (root.val < heap.peek()) {
            heap.poll();
            heap.offer(root.val);
        }
        inOrderHelper(root.right, heap, k);
    }

    public void usingListInOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        usingListInOrder(root.left, result);
        result.add(root.val);
        usingListInOrder(root.right, result);
    }
}
