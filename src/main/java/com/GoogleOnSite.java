package com;

/*
Consider a bank with some intial amount of money. Consider an array which represents list of transactions which are going to come through customers. + means deposit - means withdrawl. Bank can choose from which customer they want to start serving the customers and they can refuse any number of customers. But once they start they have to serve till the time its impossible to serve the customers. Maximize the total customers bank can serve.

Example :
Bank has 1 unit of money intially.
Customer transactions : [1, -3, 5, -2, 1]

answer = 3

Bank starts with customer with deposit of 5
1+ 5 = 6
6 - 2 = 4
4 + 1 =5

If bank starts at in index 0 can only serve 1 customer
1+1 =2
2-3 = -1 not possible
 */
public class GoogleOnSite {

    public static int getMaxCustomer(int[] transactions, int initialAmount) {
        int maxCustomer = 0;
        int windowStart = 0;
        int windowSum = initialAmount; // initial bank balance

        for(int windowEnd = 0; windowEnd < transactions.length; windowEnd++) {
            windowSum = windowSum + transactions[windowEnd];

            while(windowSum <= 0) {
                windowSum = windowSum - (transactions[windowEnd]) ;
                windowStart = windowEnd + 1;
            }
            maxCustomer = Math.max(maxCustomer, windowEnd - windowStart + 1);
        }
        return maxCustomer;
    }

    public static void main(String[] args) {
        System.out.println(getMaxCustomer(new int[]{1, -3, 5, -2, 1}, 1));
        System.out.println(getMaxCustomer(new int[]{-1}, 0));
        System.out.println(getMaxCustomer(new int[]{-1, -3, -5, -2, 1}, 1));
        System.out.println(getMaxCustomer(new int[]{1, -1}, 0));
        System.out.println(getMaxCustomer(new int[]{1, -1}, 1));
    }


}
