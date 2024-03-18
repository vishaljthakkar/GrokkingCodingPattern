package com.needcode.advanced.algods.o1arrays.o3slidingwindowvariable.leetcode;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;

public class O2_LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String str) {
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

                // Why not this and use Math.max. Work it out using str = "abba" as example.
                //windowStart = charIndexMap.get(rightChar) + 1;
            }
            charIndexMap.put(rightChar, windowEnd); // insert rightChar along with the index
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length
        }
        return maxLength;
    }
}
