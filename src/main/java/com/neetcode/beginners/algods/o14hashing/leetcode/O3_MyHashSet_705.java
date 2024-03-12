package com.neetcode.beginners.algods.o14hashing.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/design-hashset/description/
public class O3_MyHashSet_705 {
    private int keySpace;
    private List<Bucket> hashTable;

    public O3_MyHashSet_705() {
        this.keySpace = 2069;
        this.hashTable = new ArrayList<>();
        for(int i = 0; i < this.keySpace; i++) {
            this.hashTable.add(new Bucket());
        }
    }

    protected int _hash(int key) {
        return key % this.keySpace;
    }

    public void add(int key) {
        int hashKey = _hash(key);
        this.hashTable.get(hashKey).insert(key);
    }

    public void remove(int key) {
        int hashKey = _hash(key);
        this.hashTable.get(hashKey).delete(key);
    }

    public boolean contains(int key) {
        int hashKey = _hash(key);
        return this.hashTable.get(hashKey).exists(key);
    }

    class Bucket {
        private List<Integer> bucket;

        public Bucket() {
            bucket = new LinkedList<Integer>();
        }

        public void insert(Integer key) {
            if (!this.bucket.contains(key)) {
                this.bucket.add(0, key);
            }
        }

        public void delete(Integer key) {
            this.bucket.remove(key);
        }

        public boolean exists(Integer key) {
             return this.bucket.contains(key);
        }
    }
}
