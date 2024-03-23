package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
If the given list was not sorted, we could have simply appended the new interval to it and used the mergeInterval
problem. But since the given list is sorted, we should try to come up with a solution better than O(nlogn)

When inserting a new interval in a sorted list, we need to first find the correct index where the new interval can be
placed.
In other words, we need to skip all the intervals which end before the start of the new interval.

So we can iterate through the given sorted list of intervals and skip all the intervals with the following condition:
interval[i].end < newInterval.start

Once we have found the correct place, we can follow an approach similar to Merge Intervals to insert and/or merge
the new interval.

There are five overlapping scenarios. See educative grokking coding pattern for more details

Our overall algorithm will look like this:
1. Skip all intervals which end before the start of the new interval, i.e., skip all intervals with
   the following condition: interval[i].end < newInterval.start

2. Let’s call the last interval ‘b’ that does not satisfy the above condition.
   If ‘b’ overlaps with the new interval (a) (i.e. b.start <= a.end),
   we need to merge them into a new interval ‘c’:
   c.start = min(a.start, b.start)
   c.end = max(a.end, b.end)

3. We will repeat the above two steps to merge ‘c’ with the next overlapping interval.


 */
// https://leetcode.com/problems/insert-interval/description/
public class O2_InsertInterval_57 {

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start; this.end = end;
        }
    }

    // It is given that intervals are already sorted.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalList = new ArrayList<>();
        List<Interval> mergedIntervals = new LinkedList<>();

        for(int[] input : intervals) {
            intervalList.add(new Interval(input[0], input[1]));
        }
        Interval newInputInterval = new Interval(newInterval[0], newInterval[1]);

        // skip ( and add to output) all intervals that come before 'newInterval'
        int i = 0;
        while(i < intervalList.size() && intervalList.get(i).end < newInputInterval.start) {
            mergedIntervals.add(intervalList.get(i));
            i = i + 1;
        }

        // merge all intervals that overlap with 'newInterval'
        while(i < intervalList.size() && intervalList.get(i).start <= newInputInterval.end) {
            newInputInterval.start = Math.min(intervalList.get(i).start, newInputInterval.start);
            newInputInterval.end = Math.max(intervalList.get(i).end, newInputInterval.end);
            i = i + 1;
        }

        // insert the new interval
        mergedIntervals.add(newInputInterval);

        // add all the remaining intervals to the output
        while(i < intervalList.size()) {
            mergedIntervals.add(intervalList.get(i));
            i = i + 1;
        }

        int[][] result = new int[mergedIntervals.size()][2];

        i = 0;
        for(Interval ival : mergedIntervals) {
            result[i] = new int[]{ival.start, ival.end};
            i = i + 1;
        }
        return result;
    }
}
