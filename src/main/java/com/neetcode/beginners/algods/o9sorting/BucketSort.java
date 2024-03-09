package com.neetcode.beginners.algods.o9sorting;

import java.util.Arrays;

public class BucketSort {

    public static int[] bucketSort(int[] nums) {
        // Assuming our array only contains 0s, 1s, 2s

        //Count the quantity of 0s, 1s and 2s
        int[] count = {0, 0 , 0};
        for(int n : nums) {
            count[n]++;
        }

        int writerIndex = 0;
        for(int i = 0; i < count.length; i++) {
            for(int j = count[i]; j > 0; j--) {
                nums[writerIndex++] = i;
            }
        }
        return nums;
    }
    public static void solution1(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int countZeros = 0, countOnes = 0, countTwos = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0 -> countZeros++;
                case 1 -> countOnes++;
                case 2 -> countTwos++;
            }
        }
        int index = 0;
        while (countZeros != 0) {
            nums[index++] = 0;
            countZeros--;
        }
        while (countOnes != 0) {
            nums[index++] = 1;
            countOnes--;
        }
        while (countTwos != 0) {
            nums[index++] = 2;
            countTwos--;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bucketSort(new int[]{1,2,0,2,1,0})));
        int[] input = {1,2,0,2,1,0};
        solution1(input);
        System.out.println(Arrays.toString(input));
    }
}
