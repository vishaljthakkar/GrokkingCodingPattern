package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
This problem follows the Merge Intervals pattern. As we have discussed under Insert Interval, there are five
overlapping possibilities between two intervals ‘a’ and ‘b’

A close observation will tell us that whenever the two intervals overlap,
one of the interval’s start time lies within the other interval.

This rule can help us identify if any two intervals overlap or not.

Now, if we have found that the two intervals overlap, how can we find the overlapped part?
Again from the above diagram, the overlapping interval will be equal to:
    start = max(a.start, b.start)
    end = min(a.end, b.end)

That is, the highest start time and the lowest end time will be the overlapping interval.
So our algorithm will be to iterate through both the lists together to see if any two intervals overlap.
If two intervals overlap, we will insert the overlapped part into a result list and move on to the
next interval which is finishing early.
 */
// https://leetcode.com/problems/interval-list-intersections/description/
public class O3_IntervalListIntersections_986 {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) { this.start = start; this.end = end; }
    }
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<Interval> first = new ArrayList<>();
        List<Interval> second = new ArrayList<>();
        List<Interval> result = new ArrayList<>();

        for(int[] fl : firstList) {
            first.add(new Interval(fl[0], fl[1]));
        }
        for(int[] sl : secondList) {
            second.add(new Interval(sl[0], sl[1]));
        }

        int i = 0, j = 0;
        while(i < first.size() && j < second.size()) {
            Interval firstInterval = first.get(i);
            Interval secondInterval = second.get(j);
            // check if the interval first intersects with second
            // check if one of the interval's start time lies within the other interval
            // This is nothing but crissxcross check. first start with second end and second start with first end
            if (firstInterval.start <= secondInterval.end && secondInterval.start <= firstInterval.end) {
                // store the intersection part
                result.add(new Interval(Math.max(firstInterval.start, secondInterval.start),
                        Math.min(firstInterval.end, secondInterval.end)));

            }
            // move next from the interval which is ending first.
            if (firstInterval.end < secondInterval.end) {
                i = i + 1;
            } else {
                j = j + 1;
            }
        }

        int[][] ret = new int[result.size()][2];
        i = 0;
        for(Interval ival : result) {
            ret[i] = new int[]{ival.start, ival.end};
            i = i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] first = new int[][]{{1, 3}, {5, 6}, {7, 9}};
        int[][] second = new int[][]{{2, 3}, {5, 7}};

        System.out.println(Arrays.deepToString(intervalIntersection(first, second)));
        // [[2, 3], [5, 6], [7, 7]]
        first = new int[][]{{1, 3}, {5, 7}, {9, 12}};
        second = new int[][]{{5, 10}};
        System.out.println(Arrays.deepToString(intervalIntersection(first, second)));
        // [[5, 7], [9, 10]]

        first = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        second = new int [][]{{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(intervalIntersection(first, second)));
        // [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]

        first = new int[][]{{1,3},{5,9}};
        second = new int[][]{};
        System.out.println(Arrays.deepToString(intervalIntersection(first, second)));
        // []
    }
}
