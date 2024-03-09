package com.neetcode.beginners.algods.o9sorting.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        return usingArraySort(nums, k);
//        return usingPriorityQueue(nums, k);
    }

    public static int usingArraySort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // This takes 40 ms (~30% improvement)
    public static int usingPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            // Keep adding to heap as long as elements are less than k
            if (i < k) {
                heap.offer(nums[i]);
                // Now that we have k elements in the heap.
                // Compare incoming elements with the top of the heap
                // With this we will only have K elements in the heap
            } else if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.poll();
    }

    /*
    // This takes 58 ms
    public static int usingPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int retVal = -1;

        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }

        while (!heap.isEmpty() && k > 0) {
            retVal = heap.poll();
            k--;
        }
        return retVal;
    }
     */
}
