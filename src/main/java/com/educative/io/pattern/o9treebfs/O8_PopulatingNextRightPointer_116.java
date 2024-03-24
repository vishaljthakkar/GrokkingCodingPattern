package com.educative.io.pattern.o9treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class O8_PopulatingNextRightPointer_116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }

    public static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            Node current = new Node(-1);
            for (int i = 0; i < queueLength; i++) {
                current.next = queue.poll();
                current = current.next;

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return root;
    }

    public static void printTree(Node root) {
        Node current = root;
        System.out.print("Traversal using next pointer: ");
        while(current != null) {
            System.out.println(current.val + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        root.right.left.left = new Node(20);
        root.right.left.right = new Node(17);
        Node node = connect(root);
        System.out.println(node);
    }
}
