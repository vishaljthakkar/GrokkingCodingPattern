package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.*;

public class O8_FindAllConflictingAppointment {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end ) { this.start = start; this.end = end; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start && end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public static void findConflictingAppointments(int[][] intervals) {
        if (intervals.length == 0) return;
        List<AbstractMap.SimpleEntry<Interval, Interval>> conflicts = new ArrayList<>();

        List<Interval> intervalList = new ArrayList<>();
        for(int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        intervalList.sort(Comparator.comparingInt(a -> a.end));
        // Min heap by interval end
        PriorityQueue<Interval> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));

        Interval first = intervalList.get(0);
        // Add the first meetings end time to the heap
        heap.offer(first);

        for(int i = 1; i < intervalList.size(); i++) {
            // If the end time of the meeting in the heap has no overlap with this meeting
            // Remove the meeting in the heap as that meeting will not contribute to our room count
            Interval thisMeeting = intervalList.get(i);
            if (thisMeeting.start >= heap.peek().end) {
                heap.poll();
            } else {
                conflicts.add(new AbstractMap.SimpleEntry<>(heap.peek(), thisMeeting));
            }
            heap.offer(thisMeeting);
        }
        System.out.println(conflicts);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{4, 5}, {2, 3}, {3, 6}, {5, 7}, {7, 8}};
        findConflictingAppointments(input);
        // [Interval{start=4, end=5}=Interval{start=3, end=6}, Interval{start=3, end=6}=Interval{start=5, end=7}]
        /*
        Appointments: [[4,5], [2,3], [3,6], [5,7], [7,8]]
        Output:
        [4,5] and [3,6] conflict.
        [3,6] and [5,7] conflict.
         */
    }
}
