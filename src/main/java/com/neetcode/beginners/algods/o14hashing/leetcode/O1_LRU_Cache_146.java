package com.neetcode.beginners.algods.o14hashing.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/submissions/193651136/

public class O1_LRU_Cache_146 {
    /*
     * The LRU cache is a hash table of keys and double linked nodes. The hash table
     * makes the time of get() to be O(1). The list of double linked nodes make the
     * nodes adding/removal operations O(1)
     */

    static class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Node head;
    private Node tail;
    private final Map<Integer, Node> cacheMap;

    public O1_LRU_Cache_146(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
    }

    /* Remove node if exists and put it in the front of the doubly linked list */
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            int value = node.value;
            removeNode(node);
            setHead(node);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            // update the value at this key
            node.value = value;
            removeNode(node);
            setHead(node);
        } else {
            Node newNode = new Node(key, value);
            if (cacheMap.size() == capacity) {
                cacheMap.remove(tail.key);
                removeNode(tail);
            }
            setHead(newNode);
            cacheMap.put(key, newNode);
        }
    }

    /* Utility function */
    private void setHead(Node node) {
        node.next = head;
        node.prev = null;
        if (head == null) {
            head = node;
        } else {
            head.prev = node;
            head = node;
        }
        if (tail == null) {
            tail = head;
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next;//node.next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;//node.prev;
        }
    }
}
