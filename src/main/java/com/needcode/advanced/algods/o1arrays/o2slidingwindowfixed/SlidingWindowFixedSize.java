package com.needcode.advanced.algods.o1arrays.o2slidingwindowfixed;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindowFixedSize {
    // Check if array contains a pair of duplicate values,
    // where the two duplicates are no farther than k positions from
    // eachother (i.e. arr[i] == arr[j] and abs(i - j) + 1 <= k).
    // O(n * k)

    public static boolean closeDuplicatesBruteForce(int[] nums, int k) {
        // interesting use of for loop condition
//        for(int windowEnd = 0; windowEnd - k + 1 < nums.length; windowEnd++) {
        for(int windowStart = 0; windowStart  < Math.min(nums.length, nums.length - k + 1); windowStart++) {
            for(int windowEnd = windowStart + 1; windowEnd < windowStart + k; windowEnd++) {
                if (nums[windowStart] == nums[windowEnd]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Same problem using sliding window.
    // O(n)
    public static boolean closeDuplicates(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(); //current window size <= k
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            int currentNum = nums[windowEnd];
            if (set.contains(currentNum)) {
                return true;
            }
//            if (windowEnd > k - 1) {
//                set.remove(nums[windowStart]);
//                windowStart++;
//            }
            // Another way to check window size
            if (windowEnd - windowStart + 1 > k ) {
                set.remove(nums[windowStart]);
                windowStart++;
            }

            set.add(currentNum);

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(closeDuplicatesBruteForce(new int[]{}, 2));
        System.out.println(closeDuplicatesBruteForce(new int[]{1}, 2));
        System.out.println(closeDuplicatesBruteForce(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(closeDuplicatesBruteForce(new int[]{2, 2, 3, 4, 5}, 2));
        System.out.println(closeDuplicatesBruteForce(new int[]{1, 2, 3, 3, 5}, 2));
        System.out.println(closeDuplicatesBruteForce(new int[]{1, 2, 3, 4, 4}, 2));

        System.out.println(closeDuplicates(new int[]{}, 2));
        System.out.println(closeDuplicates(new int[]{1}, 2));
        System.out.println(closeDuplicates(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(closeDuplicates(new int[]{2, 2, 3, 4, 5}, 2));
        System.out.println(closeDuplicates(new int[]{1, 2, 3, 3, 5}, 2));
        System.out.println(closeDuplicates(new int[]{1, 2, 3, 4, 4}, 2));
    }
}
