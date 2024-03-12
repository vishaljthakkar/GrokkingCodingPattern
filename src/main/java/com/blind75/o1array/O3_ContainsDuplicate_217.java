package com.blind75.o1array;

import java.util.*;

public class O3_ContainsDuplicate_217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;

    }

    public static boolean containsDuplicateUsingMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 0);
        }
        return false;
    }

    public boolean containsDuplicateUsingSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if (nums[i -1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
}
