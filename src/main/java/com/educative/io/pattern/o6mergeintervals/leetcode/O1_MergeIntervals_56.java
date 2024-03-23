package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.*;

// https://leetcode.com/problems/merge-intervals/
// Check out educative coding pattern for detailed explanation
// Time complexity: O(nlogn)
// Space complexity: O(n) for the result and O(n) space for sorting. For java depending on its version,
// It will either use MergeSort or TimSort (Written by joshua bloch adapted from python's tim sort)
public class O1_MergeIntervals_56 {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) { this.start = start; this.end = end; }
    }


    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;

        List<Interval>  intervalList = new ArrayList<>();
        List<Interval> mergedIntervals = new LinkedList<>();

        for(int[] input : intervals) {
            intervalList.add(new Interval(input[0], input[1]));
        }

        // Sort by the start of the interval
        //Collections.sort(intervalList, (a, b) -> Integer.compare(a.start, b.start));
        intervalList.sort((a, b) -> Integer.compare(a.start, b.start));

        Iterator<Interval> intervalIterator = intervalList.iterator();
        Interval interval = intervalIterator.next();
        int start = interval.start;
        int end = interval.end;

        while(intervalIterator.hasNext()) {
            interval = intervalIterator.next();
            if (interval.start <= end) { // overlapping intervals, adjust the 'end'
                // return true;  => If question just asks if two intervals overlap
                end = Math.max(interval.end, end);
            } else {  // non-overlapping interval, add the previous interval and reset
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // add the last interval
        mergedIntervals.add(new Interval(start, end));

        // IMPORTANT: Allocate result array like below
        // because you want to rows of intervals with each having array of size 2
        int[][] ret = new int[mergedIntervals.size()][2];
        int i = 0;
        for(Interval ival : mergedIntervals) {
            ret[i] = new int[]{ival.start, ival.end};
            i = i + 1;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 4}, {2, 5}, {7, 9}};
        int[][] result = merge(input);
        System.out.print("Merged intervals: ");
        for(int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
        // Merged intervals: [1, 5] [7, 9]

        input = new int[][]{{6, 7}, {2, 4}, {5, 9}};
        result = merge(input);
        System.out.print("Merged intervals: ");
        for(int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
        // Merged intervals: [2, 4] [5, 9]

        input = new int[][]{{1, 4}, {2, 6}, {3, 5}};
        result = merge(input);
        System.out.print("Merged intervals: ");
        for(int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
        // Merged intervals: [1, 6]
    }
}
