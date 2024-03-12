package com.neetcode.beginners.algods.o14hashing.leetcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/design-hashmap/description/

/* we could adopt the modulo operator as the hash function, since the key value is of integer type.
In addition, in order to minimize the potential collisions, it is advisable to use a prime number
as the base of modulo, e.g. 2069

We organize the storage space as an array where each element is indexed with the output value of the
hash function.

In case of collision, where two different keys are mapped to the same address, we use a bucket to hold
all the values. The bucket is a container that hold all the values that are assigned by the hash function.
We could use either a LinkedList or an Array to implement the bucket data structure.
 */
public class O2_MyHashMap_706 {
    private int keySpace;
    private List<Bucket> hashTable;
    
    public O2_MyHashMap_706() {
        this.keySpace = 2069;
        this.hashTable = new ArrayList<Bucket>();
        for(int i = 0; i < this.keySpace; i++) {
            this.hashTable.add(new Bucket());
        }
    }

    /** Values will always be non-negative */
    public void put(int key, int value) {
        int hashKey = key % this.keySpace;
        this.hashTable.get(hashKey).update(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
        int hashKey = key % this.keySpace;
        return this.hashTable.get(hashKey).get(key);
    }


    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key % this.keySpace;
        this.hashTable.get(hashKey).remove(key);
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "keySpace=" + keySpace +
                ", hashTable=" + hashTable +
                '}';
    }

    class Bucket {
        private List<AbstractMap.SimpleEntry<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new LinkedList<>();
        }

        public Integer get(Integer key) {
//            for(AbstractMap.SimpleEntry<Integer, Integer> entry : bucket)
            for(var entry : bucket) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for(var entry : bucket) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    found = true;
                }
            }
            if (!found) bucket.add(new AbstractMap.SimpleEntry<>(key, value));
        }

        public void remove(Integer key) {
            for(var entry : bucket) {
                if (entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    break;
                }
            }
        }

        @Override
        public String toString() {
            return "Bucket{" +
                    "bucket=" + bucket +
                    '}';
        }
    }

    public static void main(String[] args) {
        O2_MyHashMap_706 myHashMap = new O2_MyHashMap_706();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.put(2000, 2000);
        myHashMap.put(1, 100);
        myHashMap.put(2070, 11);
        System.out.println(myHashMap);
    }
}
