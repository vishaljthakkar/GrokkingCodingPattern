package com.educative.io.pattern.o1slidingwindow.problemchallenge;

import java.util.HashMap;

/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.
Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the
following six permutations:

abc
acb
bac
bca
cab
cba

If a string has ‘n’ distinct characters it will have n!

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.


This problem follows the Sliding Window pattern and we can use a similar sliding window strategy as
discussed in Longest Substring with K Distinct Characters. We can use a HashMap to remember the
frequencies of all characters in the given pattern. Our goal will be to match all the characters from this
HashMap with a sliding window in the given string. Here are the steps of our algorithm:

1. Create a HashMap to calculate the frequencies of all characters in the pattern.
2. Iterate through the string, adding one character at a time in the sliding window.
3. If the character being added matches a character in the HashMap, decrement its frequency in the
   map. If the character frequency becomes zero, we got a complete match.
4. If at any time, the number of characters matched is equal to the number of distinct characters in the
   pattern (i.e., total characters in the HashMap), we have gotten our required permutation.
5. If the window size is greater than the length of the pattern, shrink the window to make it equal to
   the size of the pattern. At the same time, if the character going out was part of the pattern, put it
   back in the frequency HashMap.

Time Complexity
The time complexity of the above algorithm will be O(N+M).
O(N+M) where ‘N’ and ‘M’ are the number of characters in the input string and the pattern respectively.

Space Complexity
The space complexity of the algorithm is O(M). O(M) since in the worst case,
the whole pattern can have distinct characters which will go into the HashMap.
 */
public class O1_StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        // Do input checks
        int windowStart = 0, matched = 0;

        var charFreqMap = new HashMap<Character, Integer>();
        for(char ch : pattern.toCharArray()) {
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }

        // our goal is to match all the characters from the 'charFreqMap'
        // try to extend the range [windowStart, windowEnd]
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if(charFreqMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                // character is completely matched
                if (charFreqMap.get(rightChar) == 0) {
                    matched = matched + 1;
                }
            }

            if (matched == charFreqMap.size())
                return true;

            // shrink the window by one character
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart);
                windowStart = windowStart + 1;
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0) {
                        // before putting the character back, decrement the matched count
                        matched = matched - 1;
                    }
                    // put the character back for matching
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exists: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exists: " + findPermutation("odicf", "dc"));
        System.out.println("Permutation exists: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exists: " + findPermutation("aaacb", "abc"));

    }
}
