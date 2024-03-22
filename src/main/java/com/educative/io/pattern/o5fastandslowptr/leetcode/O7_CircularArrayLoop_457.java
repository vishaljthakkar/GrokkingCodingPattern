package com.educative.io.pattern.o5fastandslowptr.leetcode;
/*
This problem involves finding a cycle in the array and, as we know, the Fast & Slow pointer method
is an efficient way to do that. We can start from each index of the array to find the cycle.
If a number does not have a cycle we will move forward to the next element.
There are a couple of additional things we need to take care of:
1. As mentioned in the problem, the cycle should have more than one element. This means that when
   we move a pointer forward, if the pointer points to the same element after the move, we have a
   one-element cycle. Therefore, we can finish our cycle search for the current element.

2. The other requirement mentioned in the problem is that the cycle should not contain both forward
   and backward movements. We will handle this by remembering the direction of each element
   while searching for the cycle. If the number is positive, the direction will be forward and if
   the number is negative, the direction will be backward. So whenever we move a pointer forward,
   if there is a change in the direction, we will finish our cycle search right there for the
   current element.
 */
// https://leetcode.com/problems/circular-array-loop/
public class O7_CircularArrayLoop_457 {

    public static boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            boolean isForward = nums[i] >=0; // if we are moving forward or not.
            int slow = i, fast = i;

            // if slow or fast becomes -1 this means we cannot find cycle for this number
            do {
                slow = findNextIndex(nums, isForward, slow); //move one step for slow pointer
                fast = findNextIndex(nums, isForward, fast); //move one step for fast pointer
                if (fast != -1) {
                    fast = findNextIndex(nums, isForward, fast); //move another step for fast pointer
                }

            } while(slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static int findNextIndex(int[] nums, boolean isForward, int currentIndex) {
        boolean direction = nums[currentIndex] >= 0;
        if (isForward != direction) {
            return -1; // change in direction, return -1;
        }
        int nextIndex = (currentIndex + nums[currentIndex]) % nums.length;
        if (nextIndex < 0) {
            nextIndex = nextIndex + nums.length; //wrap around for negative numbers
        }

        // one element cycle, return -1
        if (nextIndex == currentIndex) {
            nextIndex = -1;
        }
        return nextIndex;
    }

    public static void main(String[] args) {
//        System.out.println(circularArrayLoop(new int[]{2,-1,1,2,2}));
//        System.out.println(circularArrayLoop(new int[]{1, 2, -1, 2, 2}));
        System.out.println(circularArrayLoop(new int[]{-1,-2,-3,-4,-5,6}));
    }
}
