package com.neetcode.beginners.algods.o9sorting.leetcode;

// https://leetcode.com/problems/sort-colors/
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int countZeros = 0, countOnes = 0, countTwos = 0;
        for(int i = 0; i < nums.length; i++) {
            switch(nums[i]) {
                case 0 -> countZeros++;
                case 1 -> countOnes++;
                case 2 -> countTwos++;
            }
        }
        int index = 0;
        while(countZeros != 0) {
            nums[index++] = 0;
            countZeros--;
        }
        while(countOnes != 0) {
            nums[index++] = 1;
            countOnes--;
        }
        while(countTwos != 0) {
            nums[index++] = 2;
            countTwos--;
        }
    }
}
