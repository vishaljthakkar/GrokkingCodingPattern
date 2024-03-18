package com.needcode.advanced.algods.o1arrays.o5prefixsum.leetcode;

// https://leetcode.com/problems/find-pivot-index/

public class O3_FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int totalSum =0;

        // Find the total sum of the array.
        for(int num : nums) { totalSum += num; }

        int leftSum = 0;
        for(int i = 0; i < nums.length; i++) {
            // RightSum is the totalSum of the array - leftSum - value at current index
            int rightSum = totalSum - leftSum - nums[i];

            if ( leftSum == rightSum ) {
                return i;
            }

            // If leftSum is not equal to right sum we did not find pivot index.
            // Lets add current num to the left sum and move ahead
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
