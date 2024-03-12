package com.neetcode.beginners.algods.o13heappq.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class O1_KthLargest_703 {
    PriorityQueue<Integer> heap;
    int k;

    public O1_KthLargest_703(int k, int[] nums) {
//        heap = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue));
        heap = new PriorityQueue<>();
        this.k = k;
        for(Integer num : nums) add(num);
    }

    public int add(int val) {
        if (heap.size() < k)
            heap.offer(val);
        else {
            if (val > heap.peek()) {
                heap.poll();
                heap.offer(val);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        O1_KthLargest_703 o1KthLargest703 = new O1_KthLargest_703(3, new int[] {4, 5, 8, 2});
        System.out.println(o1KthLargest703.add(3));
        System.out.println(o1KthLargest703.add(5));
        System.out.println(o1KthLargest703.add(10));
        System.out.println(o1KthLargest703.add(9));
        System.out.println(o1KthLargest703.add(4));
    }
}
