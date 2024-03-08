package com.neetcode.beginners.algods.o3stack.leetcode;

import java.util.Stack;

// https://leetcode.com/problems/baseball-game/description/
public class O1_BaseBallGame_682 {
    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(String operation : operations) {
            switch(operation) {
                case "+" -> {
                    int score1 = stack.pop();
                    int score2 = stack.peek();
                    stack.push(score1);
                    stack.push(score1 + score2);
                }
                case "C" -> stack.pop();
                case "D" -> {
                    int score = stack.peek();
                    stack.push(score  * 2);
                }
                default -> stack.push(Integer.valueOf(operation));
            }
        }

        while(!stack.isEmpty())
            result += stack.pop();

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
