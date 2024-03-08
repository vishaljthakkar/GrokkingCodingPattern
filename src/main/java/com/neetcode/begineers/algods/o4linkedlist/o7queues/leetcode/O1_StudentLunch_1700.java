package com.neetcode.begineers.algods.o4linkedlist.o7queues.leetcode;

// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class O1_StudentLunch_1700 {
    /*
    Time complexity:
    1. Initializing Queues and Stacks: The loop to fill studentsQueue and foodStack runs for n
    iterations, where n is the number of students/sandwiches. This part is O(n).
    2. Main While Loop: The while loop can run a maximum of n iterations for each sandwich
    (in the worst-case scenario). In the worst case, each student will be dequeued and enqueued
    once per sandwich, leading to n^2 operations.
     Therefore, the time complexity is O(n^2).

     Space Complexity: O(n)
     */
    public static int countStudents(int[] students, int[] sandwiches) {
        int lenStudents = students.length;
        Queue<Integer> studentsQueue = new LinkedList<>();
        Stack<Integer> foodStack = new Stack<>();

        for (int i = 0; i < lenStudents; i++) {
            studentsQueue.offer(students[i]);
            // Questions says i = 0 is the top of the stack for sandwiches
            // so we have to add elements in reverse order of the array
            foodStack.push(sandwiches[lenStudents - i - 1]);
        }

        int counter = 0;
        /* - The loop terminates when the counter becomes equal to the size of the food stack.
        This means that we've cycled through all students without any of them taking the top sandwich,
        indicating that the remaining students cannot pick any more sandwiches.
         */
        while (counter < foodStack.size()) {
            if (studentsQueue.peek().equals(foodStack.peek())) {
                studentsQueue.poll();
                foodStack.pop();
                counter = 0;
            } else {
                // add student back to queue
                int student = studentsQueue.poll();
                studentsQueue.offer(student);
                counter++;
            }
        }
        return studentsQueue.size();
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}
