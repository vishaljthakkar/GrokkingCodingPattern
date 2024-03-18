package com.needcode.advanced.algods.o1arrays.o5prefixsum;

import java.util.ArrayList;
import java.util.List;

public class PrefixSum {
    List<Integer> prefix;
    int[] arr;

    public PrefixSum(int[] nums) {
        arr = new int[nums.length];
        arr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            arr[i] = nums[i] + arr[i - 1];
        }
        prefix = new ArrayList<>();
        int total = 0;
        for(int num : nums) {
            total = total + num;
            prefix.add(total);
        }
    }

    public int rangeSum(int left, int right) {
//        int preRight = prefix.get(right);
//        int preLeft = (left > 0) ? prefix.get(left - 1) : 0;
//        return (preRight - preLeft);

        if (left > 0) {
            return arr[right] - arr[left - 1];
        } else {
            return arr[right];
        }
    }

    public static void main(String[] args) {
        PrefixSum prefixSum = new PrefixSum(new int[]{2,3,4,1,3,0});
        System.out.println(prefixSum.rangeSum(0, 2));
        System.out.println(prefixSum.rangeSum(1, 4));
    }
}
