package com.educative.io.pattern.o1slidingwindow.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;


@Slf4j
public class O5_MaxFruitCountOf2Types {
/*
Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is
to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each
tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

This transforms the current problem into Longest Substring with K Distinct Characters where K=2
 */

    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = 0;
        var fruitFreqMap = new HashMap<Character, Integer>();

        // try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char rightFruit = arr[windowEnd];
            fruitFreqMap.put(rightFruit, fruitFreqMap.getOrDefault(rightFruit, 0) + 1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while(fruitFreqMap.size() > 2) {
                char leftFruit = arr[windowStart];
                fruitFreqMap.put(leftFruit, fruitFreqMap.get(leftFruit) - 1);
                if (fruitFreqMap.get(leftFruit) == 0) {
                    fruitFreqMap.remove(leftFruit);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        char[] input = new char[]{'A', 'B', 'C', 'A', 'C'};
        log.info("Maximum number of fruits in both the baskets: " + findLength(input));
        log.info("Maximum number of fruits in both the baskets: " + findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));

    }
}
