package com.educative.io.pattern.o3monotonicstack.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/daily-temperatures/
// https://www.youtube.com/watch?v=m4hvxzLoN_I&feature=emb_logo
public class O1_DailyTemperatures_739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        // We want to find first larger element to the right
        // Monotonic decreasing stack - Maintain descending order from bottom of the stack to top
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int coldIndex = stack.poll();

                result[coldIndex] = i - coldIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,60, 90})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70})));
        /*
        [1, 1, 4, 2, 1, 1, 0, 0]
        [1, 1, 1, 0]
        [1, 1, 0]
        [8, 1, 5, 4, 3, 2, 1, 1, 0, 0]
         */
    }
}
