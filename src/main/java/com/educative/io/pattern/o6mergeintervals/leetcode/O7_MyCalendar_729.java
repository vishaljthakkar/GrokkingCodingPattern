package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class O7_MyCalendar_729 {
    List<Interval> schedules;
    TreeMap<Integer, Integer> calendar;

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public O7_MyCalendar_729() {
        schedules = new LinkedList<>();
        calendar = new TreeMap<>();
    }

    // If we sort by the start time all we have to check is the floor and ceiling.
    // Basically one before and one after the given start time and then decide if there is an overlap.
    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) {
            return false;
        }

        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) {
            return false;
        }

        calendar.put(start, end);
        return true;
    }

    // This takes O(n^2). for every interval we for loop and then add.
    public boolean book2(int start, int end) {
        if (start >= end) {
            return false;
        }
        Interval newInterval = new Interval(start, end);

        for (Interval interval : schedules) {

            // Different ways to check overlap.
            if (Math.max(interval.start, newInterval.start) < Math.min(interval.end, newInterval.end)) {
                return false;
            }
        }
        schedules.add(newInterval);
        return true;
    }
}

