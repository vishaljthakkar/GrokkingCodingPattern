package com.needcode.advanced.algods.o1arrays.o4twopointers.leetcode;

// https://leetcode.com/problems/valid-palindrome/
public class O1_ValidPalindrome_125 {

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
            return true;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left = left + 1;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right = right - 1;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("0P"));
    }
}
