package com.needcode.advanced.algods.o1arrays.o3slidingwindowvariable.leetcode;

import java.util.HashMap;
// https://leetcode.com/problems/longest-repeating-character-replacement/
public class O3_LongestRepeatingCharacterReplacement_424 {
    public static int characterReplacement(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        var letterFrequencyMap = new HashMap<Character, Integer>();

        // try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is repeating
            // 'maxRepeatLetterCount' times, this means we can have a window which has one letter repeating
            // 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // If the remaining letters are more than 'K', it is time to shrink the window as we  are not allowed
            // to replace more than 'k' letters
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABBA", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
