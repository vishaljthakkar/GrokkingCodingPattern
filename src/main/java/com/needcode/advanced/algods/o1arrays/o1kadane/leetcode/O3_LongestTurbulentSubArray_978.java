package com.needcode.advanced.algods.o1arrays.o1kadane.leetcode;

// https://leetcode.com/problems/longest-turbulent-subarray/description/

// In this problem we have to find the length of subarray such that we get alternating comparison between adjacent
// array numbers
// For example: [9,4,2,10,7,8,8,1,9]
// 9 > 4 > 2 < 10 > 7 < 8 = 8 > 1 < 9
// In the above example there are 2 alternating comparisons
// 1. 4 > 2 < 10 > 7 < 8 of length 5 and
// 2. 8 > 1 < 9 of length 3. ANSWER is Max = 5.
// Anytime we find that alternating comparison is not happening, we have to shrink the window by moving the windowStart
// In the above example when our windowEnd reaches second 8 after equal sign we have to shrink the window by moving the
// windowStart.  In our code below, in the first 2 if conditions we are always moving windowEnd by 1, so we will reach
// second 8. if value at windowEnd which is 8 matches value at windowEnd - 1 which is also 8 we need to match windowStart
// with windowEnd and then move windowEnd ahead one step. If  vaule windowEnd and windowEnd - 1 are not equal then we need to
// keep windowStart one step backwards.

public class O3_LongestTurbulentSubArray_978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 0) return 0;

        int windowStart = 0;
        int windowEnd = 1;
        int maxLength = 1;
        String previousComparisonSign = "";

        while(windowEnd < arr.length) {
            if (arr[windowEnd - 1] > arr[windowEnd] && !previousComparisonSign.equals(">")) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowEnd = windowEnd + 1;
                previousComparisonSign = ">";
            } else if (arr[windowEnd - 1] < arr[windowEnd] && !previousComparisonSign.equals("<")) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowEnd = windowEnd + 1;
                previousComparisonSign = "<";
            } else {
                windowEnd = arr[windowEnd] == arr[windowEnd - 1] ? windowEnd + 1 : windowEnd;
                windowStart = windowEnd - 1;
                previousComparisonSign = "";
            }
        }
        return maxLength;
    }
}
