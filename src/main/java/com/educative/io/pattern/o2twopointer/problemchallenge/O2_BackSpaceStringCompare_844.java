package com.educative.io.pattern.o2twopointer.problemchallenge;

/*
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.

Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.

To compare the given strings, first, we need to apply the backspaces. An efficient way to do this would be from the
end of both the strings. We can have separate pointers, pointing to the last element of the given strings.
We can start comparing the characters pointed out by both the pointers to see if the strings are equal. If, at any stage,
the character pointed out by any of the pointers is a backspace (’#’), we will skip and apply the backspace until
we have a valid character available for comparison.
 */
// https://leetcode.com/problems/backspace-string-compare/
public class O2_BackSpaceStringCompare_844 {
    public static boolean backspaceCompare(String str1, String str2) {
        // use two pointer approach to compare the strings
        int index1 = str1.length() - 1;
        int index2 = str2.length() - 1;


        // The 'OR' check here is very critical because given that we have # character
        // some strings will end before other string.
        while(index1 >= 0 ||  index2 >= 0) {
            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);

            // reached the end of both strings
            if (i1 < 0 && i2 < 0) {
                return true;
            }

            // reached the end of one of the strings
            if (i1 < 0 || i2 < 0) {
                return false;
            }

            // check if characters are equal
            if (str1.charAt(i1) != str2.charAt(i2)) {
                return false;
            }
            index1 = i1 - 1;
            index2 = i2 -1;
        }
        return true;
    }

    public static int getNextValidCharIndex(String str, int index) {
        int backSpaceCount = 0;
        while(index >= 0) {
            if (str.charAt(index) == '#') {
                backSpaceCount = backSpaceCount + 1; // found a backspace character
            } else if (backSpaceCount > 0) { // non backspace character
                backSpaceCount = backSpaceCount - 1;
            } else {
                break;
            }
            index--; // skip a backspace or valid character
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("xy#z", "xzz#"));
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw")); // btw tw
        System.out.println(backspaceCompare("bbbextm", "bbb#extm"));
    }
}
