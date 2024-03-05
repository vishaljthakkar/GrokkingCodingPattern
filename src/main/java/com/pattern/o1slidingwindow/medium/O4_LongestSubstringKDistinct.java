package com.pattern.o1slidingwindow.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/*
Given a string, find the length of the longest substring in it with no more than K distinct characters

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

The time complexity of the above algorithm will be O(N). O(N) where ‘N’ is the number of characters in the input string.
The outer for loop runs for all characters and the inner while loop processes each character only once,
therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N)

The space complexity of the algorithm is O(K) as we will be storing a maximum of ‘K+1’ characters in the HashMap
 */

@Slf4j
public class O4_LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if (str == null || str.isEmpty() || k > str.length()) {
            throw new IllegalArgumentException();
        }

        int windowStart = 0, maxLength = 0;
        var charFreqMap = new HashMap<Character, Integer>();


        // in the following loop we will try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'K' distinct characters in the freq map
            while(charFreqMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if (charFreqMap.get(leftChar) == 0) {
                    charFreqMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            // remember the maximum length
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String input = "cbbebi";
        log.info("length of the longest substring in it with no more than K distinct characters: " +
                findLength(input, 3));
        log.info("length of the longest substring in it with no more than K distinct characters: " +
                findLength("araaci", 1));
        log.info("length of the longest substring in it with no more than K distinct characters: " +
                findLength("araaci", 2));

    }
}
