package com.educative.io.pattern.o3monotonicstack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/online-stock-span/submissions/462824851/
public class O5_OnlineStockSpan_901 {
    Deque<Stock> stack;

    class Stock {
        int price;
        int valueLessThanOrEqualToMe;

        public Stock(int price, int valueLessThanOrEqualToMe) {
            this.price = price;
            this.valueLessThanOrEqualToMe = valueLessThanOrEqualToMe;
        }
    }

    public O5_OnlineStockSpan_901() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int valueLessThanOrEqualToMe = 1;
        // find first largest element on the right.
        // monotonically decreasing stack
        while(!stack.isEmpty() && price >= stack.peek().price) {
            // Since we are evicting stocks smaller than current stock price
            // we also have to maintain that count when we insert this stock
            // in the stack. This will tell us how many stocks were less than
            // or equal to current stock price.
            valueLessThanOrEqualToMe = valueLessThanOrEqualToMe + stack.pop().valueLessThanOrEqualToMe;
        }
        // initially I am the only entry so I will go with 1.
        stack.push(new Stock(price, valueLessThanOrEqualToMe));
        return stack.peek().valueLessThanOrEqualToMe;
    }
}

