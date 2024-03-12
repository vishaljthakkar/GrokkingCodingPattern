package com.blind75.o1array;

public class O2_BestTimeByAndSellStock_121 {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }

    // Time Limit Exceeded O(N^2)
    public static int maxProfitBT(int[] prices) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max <= 0 ? 0 : max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
