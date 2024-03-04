package com.pattern.slidingwindow.hard;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/*
Given a string, find the length of the longest substring which has no repeating characters.

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".

Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
@Slf4j
public class O6_NoRepeatSubString {


    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        var charIndexMap = new HashMap<Character, Integer>();

        // try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            // Basic logic: Have we seen this character before? At what Index?

            // if the map already contains the rightChar, shrink the window from the beginning so that
            // we have only one occurrence of rightChar
            // For example: a b c a c b b. We saw 'a' at index 0 first then 'a' again at index 3.
            // We have to move the window start index just ahead of the last seen index which in this case would be 1
            // so that we get [b c a]. Next iteration we see 'b' again at index 5 and last we saw at '1'. So we will move
            // start of the window at 2.
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky, in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the lastIndex of 'rightChar', we will keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert rightChar along with the index
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length
        }
        return maxLength;
    }

    public static void main(String[] args) {
        log.info("length of the longest substring which has no repeating characters: "+ findLength("aabccbb"));
        log.info("length of the longest substring which has no repeating characters: "+ findLength("abbbb"));
        log.info("length of the longest substring which has no repeating characters: "+ findLength("abccde"));
    }
}
