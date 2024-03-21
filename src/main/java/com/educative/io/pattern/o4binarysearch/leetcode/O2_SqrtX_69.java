package com.educative.io.pattern.o4binarysearch.leetcode;

public class O2_SqrtX_69 {
    public static int mySqrt(int x) {
        // return mySqrtOption1(x);
        return mySqrtOption2(x);
    }

    public int mySqrtOption1(int x) {
        if (x == 0) return x;
        // since low cannot be zero and high cannot more than x
        int low = 1;
        int high = x;

        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok(mid, x)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        // Why we are returning low and not high.
        // Because we have to return the floor value.
        return low;
    }
    // F F F F 'T' T T T T
    public static boolean ok(int mid, int x) {
        // Why > and not >=. For this just workout with number 8
        // This number is the reason for doing x / mid vs mid * mid > x
        // 2147395599
        return mid > x / mid;
    }


    // From above we know that low is of more importance in this question
    // Lets give responsibility to low
    public static int mySqrtOption2(int x) {
        if (x == 0)
            return 0;

        int low = 1, high = x;
        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok2(x, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Is mid ^ 2 <= x
    // T T 'T' F F F F F
    private static boolean ok2(int x, int mid) {
        // return mid * mid <= x;
        // This condition results in integer overflow for 2147395599
        return mid <= x / mid;
    }

    // What if we need to return float value?
    public static double sqrtFloat(int x) {
        if (x == 0) return 0;

        double low = 1, high = x, epsilon = 1e-6; // precision of 6 places post decimal
//        while(high - low > epsilon) {
        while(low + epsilon < high) {
            double mid = low + (high - low) / 2;
            if (ok3(x, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static boolean ok3(int x, double mid) {
        return mid <= x / mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(8));
        System.out.println(sqrtFloat(8));
        System.out.println(mySqrt(9));
        // This is the reason we are doing mid > x /mid and not mid * mid > x
        System.out.println(mySqrt(2147395599));
        // 0
        // 1
        // 1
        // 1
        // 2
        // 3
        // 46339
    }

}
