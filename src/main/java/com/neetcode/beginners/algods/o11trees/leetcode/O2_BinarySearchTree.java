package com.neetcode.beginners.algods.o11trees.leetcode;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
// https://leetcode.com/problems/delete-node-in-a-bst/
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.HashMap;
import java.util.Map;

public class O2_BinarySearchTree {

    public static TreeNode search(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        return (val < root.val) ? search(root.left, val) : search(root.right, val);
    }

    // Return the minimum value node of the BST.
    public TreeNode minValueNode(TreeNode root) {
        TreeNode current = root;
        while (current != null && current.left != null)
            current = current.left;

        return current;
    }

    // Return the maximum value node of the BST.
    public TreeNode maxValueNode(TreeNode root) {
        TreeNode current = root;
        while (current != null && current.right != null)
            current = current.right;

        return current;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public TreeNode remove(TreeNode root, int val) {
        if (root == null)
            return null;

        if (val > root.val) {
            root.right = remove(root.right, val);
        } else if (val < root.val) {
            root.left = remove(root.left, val);
        } else { // equals
            // Handle the case with one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else { // both the childs are present
                // Find the minimum value node from the right subtree and
                // replace the value with this node. Now we have duplicate value node.
                // So lets find recursively the duplicate node and delete it.
                TreeNode minNode = minValueNode(root.right);
                root.val = minNode.val;
                root.right = remove(root.right, minNode.val);
            }
        }
        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If both p and q are lesser than parent
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
            // If both p and q are greater than parent
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    // rootIndex should increment across function calls. No need to reset in between.
    static int rootIndex;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int leftEnd = 0;
        int rightEnd = preorder.length;

        // Map of inorder elements to its index
        Map<Integer, Integer> inOrderLookup = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inOrderLookup.put(inorder[i], i);
        }

        TreeNode root = buildTreeHelper(preorder,  inOrderLookup, leftEnd, rightEnd);
        return root;
    }

    public static TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> inOrderLookup,
                                                  int leftEnd, int rightEnd) {

        if (leftEnd == rightEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[rootIndex]);

        int inOrderIndex = inOrderLookup.get(root.val);
        rootIndex = rootIndex + 1;

        int prevRightEnd = rightEnd;
        leftEnd = leftEnd;
        rightEnd = inOrderIndex;

        root.left = buildTreeHelper(preorder, inOrderLookup, leftEnd, rightEnd);

        leftEnd = inOrderIndex + 1;
        rightEnd = prevRightEnd;

        root.right = buildTreeHelper(preorder, inOrderLookup, leftEnd, rightEnd);
        return root;

    }
}
