package com.educative.io.pattern.o1slidingwindow.problemchallenge;

import java.util.HashMap;

/*
Given a string and a pattern, find the smallest substring in the given string which has all the
characters of the given pattern.

Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"

Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".

Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.
 */
public class O3_MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;

        var charFreqMap = new HashMap<Character, Integer>();
        for(char ch : pattern.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }

        // try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                // count every matching of character
                if (charFreqMap.get(rightChar) >= 0) {
                    matched = matched + 1;
                }
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while(matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart);
                windowStart = windowStart + 1;
                if (charFreqMap.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we will decrement the matched
                    // count only when a useful occurrence of a matched character is going out of the window
                    if (charFreqMap.get(leftChar) == 0) {
                        matched = matched - 1;
                    }
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("aabdec", "abc"));
        System.out.println(findSubstring("abdabca", "abc"));
        System.out.println(findSubstring("adcad", "abc"));
    }
}
