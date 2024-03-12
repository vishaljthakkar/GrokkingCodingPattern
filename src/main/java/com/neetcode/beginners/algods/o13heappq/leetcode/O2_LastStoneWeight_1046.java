package com.neetcode.beginners.algods.o13heappq.leetcode;

import java.util.PriorityQueue;

//     https://leetcode.com/problems/last-stone-weight/
public class O2_LastStoneWeight_1046 {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        // This is very slow
//        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());

        for(int stone : stones)
            heap.offer(stone);

        while(heap.size() > 1 ) {
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            if (stone1 == stone2) continue;
            heap.offer((stone1 < stone2) ? (stone2 - stone1) : (stone1 - stone2));
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }

    public static void main(String[] args) {
//        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{2, 2}));
    }
}
