package com.neetcode.begineers.algods.O3stack.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class O2_ValidParentheses_20 {
    public static boolean isValid(String s) {
        var stack = new Stack<Character>();
        if (s == null || s.isEmpty())
            return true;

        // If there are equal number of opening and closing brackets
        // length of the string should be even
        if (s.length() % 2 != 0)
            return false;

        for(char ch : s.toCharArray()) {
            switch(ch) {
                case '(', '[', '{' -> {
                    stack.push(ch);
                    continue;
                }
            }
            if (stack.isEmpty() ||
                    (ch == ')' && stack.peek() != '(') ||
                    (ch == ']' && stack.peek() != '[') ||
                    (ch == '}' && stack.peek() != '{')
            ) {
                return false;
            } else
                stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("((([]}))"));
        System.out.println(isValid("((([])))"));
    }
}
