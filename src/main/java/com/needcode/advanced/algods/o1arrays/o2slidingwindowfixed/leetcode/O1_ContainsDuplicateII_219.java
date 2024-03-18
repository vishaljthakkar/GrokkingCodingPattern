package com.needcode.advanced.algods.o1arrays.o2slidingwindowfixed.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate-ii/
public class O1_ContainsDuplicateII_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;

        Set<Integer> set = new HashSet<>();
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            int currentNum = nums[windowEnd];

            if (set.contains(currentNum)) return true;

            // Since sent contains unique element we can also do this
            // if (set.size() >= k) {
            if (windowEnd - windowStart >= k) {
                set.remove(nums[windowStart]);
                windowStart = windowStart + 1;
            }
            set.add(currentNum);
        }
        return false;
    }
}
