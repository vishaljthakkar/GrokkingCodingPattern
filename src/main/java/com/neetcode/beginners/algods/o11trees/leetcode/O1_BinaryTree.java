package com.neetcode.beginners.algods.o11trees.leetcode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
// https://leetcode.com/problems/binary-tree-right-side-view/

public class O1_BinaryTree {
    static int index;

    public static TreeNode buildBinaryTreeFromPreOrder(int[] preorder) {
        index++;
        if (preorder[index] == -1)
            return null;

        TreeNode root = new TreeNode(preorder[index]);
        root.left = buildBinaryTreeFromPreOrder(preorder);
        root.right = buildBinaryTreeFromPreOrder(preorder);
        return root;
    }

    /* Traversals in a Binary Tree */
    // In Order Traversal (Ascending): left, root, right.
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    // In Order Traversal (Descending):  right, root, left.
    public void inorderReverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderReverse(root.right);
        System.out.println(root.val);
        inorderReverse(root.left);
    }

    // Pre Order Traversal: root, left, right
    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    // Post Order Traversal: left, root, right
    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        if (root == null)
            return result;
        inOrderHelper(root, result);
        return result;
    }

    public static void inOrderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left, result);
        result.add(root.val);
        inOrderHelper(root.right, result);
    }

    public static List<Integer> inOrderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (!stack.isEmpty()) {
                    current = stack.pop();
                    result.add(current.val);
                    current = current.right;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    // Level Order Traversal. Prints node per level
    public static Map<Integer, List<Integer>> levelOrderTraversal(TreeNode root) {
        Map<Integer, List<Integer>> result = new HashMap<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> partial = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                partial.add(current.val);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            result.put(level, partial);
            level = level + 1;
        }
        return result;
    }


    public static List<Integer> rightSideView(TreeNode root) {
        // Slow. Takes 2ms
        // return rightSideViewStack(root);

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            if (current != null) result.add(current.val);
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

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Map<Integer, List<Integer>> tmap = new TreeMap<>();
        Queue<AbstractMap.SimpleEntry<Integer, TreeNode>> queue = new LinkedList<>();

        queue.offer(new AbstractMap.SimpleEntry<>(0, root));

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                var current = queue.poll();
//                AbstractMap.SimpleEntry<Integer, TreeNode> current = queue.poll();

                int column = current.getKey();
                TreeNode node = current.getValue();

                tmap.putIfAbsent(column, new ArrayList<>());
                tmap.get(column).add(node.val);

                if (node.left != null) queue.offer(new AbstractMap.SimpleEntry<>(column - 1, node.left));
                if (node.right != null) queue.offer(new AbstractMap.SimpleEntry<>(column + 1, node.right));
            }
        }

        result.addAll(tmap.values());
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = O2_BinarySearchTree.buildTree(new int[]{6,2,0,4,3,5,8,7,9}, new int[]{0,2,3,4,5,6,7,8,9});

        System.out.println(inorderTraversal(root));
        System.out.println(inOrderTraversalIterative(root));
        System.out.println(levelOrderTraversal(root));

        System.out.println(rightSideView(root));
        System.out.println(rightSideViewStack(root));

        System.out.println(verticalOrder(root));
    }
}


