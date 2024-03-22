package com.educative.io.pattern.o5fastandslowptr.leetcode;

import java.util.HashSet;

/*
Input: 23
Output: true (23 is a happy number)
Explanations: Here are the steps to find out that 23 is a happy number:

 4 + 9 = 13 = 1 + 9 = 10 = 1 + 0 = 1//

 12 = 1 + 4 = 5 = 25 = 4 + 25 = 29 = 4 + 81 = 85 = 89 = 145 = 42 = 20 = 4 = 16 = 37 = 58 = 89
 89 repeats and cycle continues
 The process, defined above, to find out if a number is a happy number or not, always ends in a cycle. If
 the number is a happy number, the process will be stuck in a cycle on number ‘1,’ and if the
 number is not a happy number then the process will be stuck in a cycle with a set of numbers.
 As we saw in Example-2 while determining if ‘12’ is a happy number or not, our process will
 get stuck in a cycle with the following numbers: 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89

 We saw in the LinkedList Cycle problem that we can use the Fast & Slow pointers method to find a cycle
 among a set of elements. As we have described above, each number will definitely have a cycle.
 Therefore, we will use the same fast & slow pointer strategy to find the cycle and once the cycle is found,
 we will see if the cycle is stuck on number ‘1’ to find out if the number is happy or not.
 */
// https://leetcode.com/problems/happy-number/description/
public class O3_HappyNumber_202 {

    public static boolean isHappy(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = findSquareNum(slow); // move one step
            fast = findSquareNum(findSquareNum(fast)); // move two steps
        } while(slow != fast); // found the cycle
        return slow == 1; // see if the cycle is stuck on the number 1.
    }

    private static int findSquareNum(int num) {
        int sum = 0;
        int digit;
        while(num > 0) {
            digit = num % 10;
            sum = sum + digit * digit;
            num = num / 10;
        }
        return sum;
    }

    // 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
    private static boolean isHappyHashSet(int num) {
        HashSet<Integer> set = new HashSet<>();
        while(num != 1 && !set.contains(num)) {
            System.out.print(num + " -> ");
            set.add(num);
            num = findSquareNum(num);
        }
        System.out.println(num);
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(23));
        System.out.println(isHappyHashSet(23));

        System.out.println(isHappy(12));
        System.out.println(isHappyHashSet(12));
        // true
        // 23 -> 13 -> 10 -> 1
        // true
        // false
        // 12 -> 5 -> 25 -> 29 -> 85 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
        // false
    }
}
