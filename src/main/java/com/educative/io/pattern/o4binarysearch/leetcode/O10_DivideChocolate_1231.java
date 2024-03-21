package com.educative.io.pattern.o4binarysearch.leetcode;

public class O10_DivideChocolate_1231 {
    public static int maximizeSweetness(int[] sweetness, int K) {
        int persons = K + 1;
        // Giving responsibility to lo
        int lo = 1; // Valid value as we want to find minimum of Maximum
        int hi = (int) 1e9 / (persons) + 1; // Maximum sweetness per person.
        // Doing +1 to make hi point to wrong value.

        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (ok(sweetness, mid, persons)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // Can I get atleast 'mid' sweetness
    // TTTTT'T'FFFFF
    private static boolean ok(int[] sweetness, int mid, int persons) {
        int currentSweetness = 0;
        int cuts = 0;

        for(int s : sweetness) {
            currentSweetness = currentSweetness + s;
            // I got my fill of sweetness. Lets try to cut and see if we can distribute.
            if (currentSweetness >= mid) {
                cuts = cuts + 1;
                currentSweetness = 0;

                // I was able to divide the chocalate with 'mid' sweetness let me see if I can do better
                // by increasing 'mid' to maximize sweetness
                if (cuts >= persons) {
                    return true;
                }
            }
        }
        // I could not divide chocolate in to persons with 'mid' sweetness.
        // My sweetness given by 'mid' is too high. Lets reduce by moving high
        return false;
    }

    public static void main(String[] args) {
        System.out.println(maximizeSweetness(new int[]{1,2,3,4,5,6,7,8,9}, 5));
    }
}
