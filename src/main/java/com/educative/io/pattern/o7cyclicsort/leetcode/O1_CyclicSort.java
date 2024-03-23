package com.educative.io.pattern.o7cyclicsort.leetcode;

import java.util.Arrays;

/*
We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from
1 to ‘n’ based on their creation sequence. This means that the object with sequence number ‘3’ was
created just before the object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence number in  O(n) and without
any extra space. For simplicity, let’s assume we are passed an integer array containing only
the sequence numbers, though each number is actually an object.

Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]

Input: [2, 6, 4, 3, 1, 5]
Output: [1, 2, 3, 4, 5, 6]

Input: [1, 5, 6, 4, 3, 2]
Output: [1, 2, 3, 4, 5, 6]

Idea:

As we know, the input array contains numbers in the range of 1 to ‘n’. We can use this fact to devise
an efficient way to sort the numbers. Since all numbers are unique, we can try placing each number
at its correct place, i.e., placing ‘1’ at index ‘0’, placing ‘2’ at index ‘1’, and so on.

To place a number (or an object in general) at its correct index, we first need to find that number.
If we first find a number and then place it at its correct place, it will take us O(n^2) which is not acceptable.

Instead, what if we iterate the array one number at a time, and if the current number we are iterating is
not at the correct index, we swap it with the number at its correct index. This way we will go through
all numbers and place them in their correct indices, hence, sorting the whole array.

Time Complexity: O(n)
Although we are not incrementing the index i when swapping the numbers, this will result in more than ‘n’
iterations of the loop, but in the worst case scenario, the while loop will swap a total of ‘n-1’ numbers
and once a number is at its correct index, we will move on to the next number by incrementing i.
So overall, our algorithm will take O(n) + O(n - 1) ~ O(n)

Space Complexity: O(1)
 */
public class O1_CyclicSort {

    public static void sort(int[] nums) {
       int i = 0;
       while(i < nums.length) {
           int numberAtThisIndex = nums[i];
           int idealIndexOfNumber = nums[i] - 1;
           if (numberAtThisIndex != nums[idealIndexOfNumber]) {
               swap(nums, i, idealIndexOfNumber);
           } else {
               i = i + 1;
           }
       }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] input  = {3, 1, 5, 4, 2};
        sort(input);
        System.out.println(Arrays.toString(input));

        input  = new int[]{2, 6, 4, 3, 1, 5};
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
