package com.pattern.o1slidingwindow.hard;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/*
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
find the length of the longest substring having the same letters after replacement.

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".


Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
@Slf4j
public class O7_CharacterReplacement {

    public static int findLength(String str, int k) {
        if (k < 0 || k > str.length()) {
            throw new IllegalArgumentException();
        }
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
        log.info("Length of the longest substring having the same letters after replacement: "+
                findLength("aabccbb", 2));
        log.info("Length of the longest substring having the same letters after replacement: "+
                findLength("abbcb", 1));
        log.info("Length of the longest substring having the same letters after replacement: "+
                findLength("abccde", 1));

    }
}
