package com.educative.io.pattern.o1slidingwindow.problemchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string and a pattern, find all anagrams of the pattern in the given string.
Anagram is actually a Permutation of a string. For example, “abc” has the  six anagrams.
Similar to previous problem.

Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

Time Complexity
The time complexity of the above algorithm will be O(N +M)where ‘N’ and ‘M’ are the number of
characters in the input string and the pattern respectively.

Space Complexity
The space complexity of the algorithm O(M) since in the worst case, the whole pattern can have
distinct characters which will go into the HashMap. In the worst case, we also need O(N) space for the
result list, this will happen when the pattern has only one character and the string contains only that  character
 */
public class O2_StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        int windowStart = 0, matched = 0;
        var resultIndices = new ArrayList<Integer>();

        var patternFreqMap = new HashMap<Character, Integer>();

        for(char ch : pattern.toCharArray()) {
            patternFreqMap.put(ch, patternFreqMap.getOrDefault(ch, 0) + 1);
        }

        // Our goal is to match all the characters from the map with the current window
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            // decrement the freq of the matched character
            if (patternFreqMap.containsKey(rightChar)) {
                patternFreqMap.put(rightChar, patternFreqMap.get(rightChar) - 1);

                if (patternFreqMap.get(rightChar) == 0) {
                    matched = matched + 1;
                }
            }

            // Have we found an anagram?
            if (matched == patternFreqMap.size()) {
                resultIndices.add(windowStart);
            }


            // shrink the window
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart);
                windowStart = windowStart + 1;
                if (patternFreqMap.containsKey(leftChar)) {
                    if (patternFreqMap.get(leftChar) == 0) {
                        matched = matched - 1; // before putting the character back decrement the matched count
                    }
                    // put the character back
                    patternFreqMap.put(leftChar, patternFreqMap.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println("starting indices of the anagrams of the pattern in the given string: " +
                findStringAnagrams("ppqp", "pq"));
        System.out.println("starting indices of the anagrams of the pattern in the given string: " +
                findStringAnagrams("abbcabc", "abc"));
    }
}
