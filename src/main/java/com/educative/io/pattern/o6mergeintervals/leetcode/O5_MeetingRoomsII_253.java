package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class O5_MeetingRoomsII_253 {
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
    }

    public static int minMeetingRooms(int[][] intervals) {
       if (intervals.length == 0) return 0;

       List<Interval> intervalList = new ArrayList<>();
       for(int[] interval : intervals) {
           intervalList.add(new Interval(interval[0], interval[1]));
       }
       intervalList.sort((a, b) -> Integer.compare(a.start, b.start));

        // Min heap based on end time
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        Interval first = intervalList.get(0);
        // Add the first meetings end time to the heap
        heap.offer(first);

        for(int i = 1; i < intervalList.size(); i++) {
            // If the end time of the meeting in the heap has no overlap with this meeting
            // Remove the meeting in the heap as that meeting will not contribute to our room count
            // That meeting has ended.
            Interval thisMeeting = intervalList.get(i);
            if (thisMeeting.start >= heap.peek().end) {
                heap.poll();
            }
            heap.offer(thisMeeting);
        }
        //All the conflicting meetings are part of the heap.
        return heap.size();
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(input)); // 2

        input = new int[][]{{7,10},{2,4}};
        System.out.println(minMeetingRooms(input)); // 1

        input = new int[][]{{9,10},{4,9},{4,17}};
        System.out.println(minMeetingRooms(input)); // 2

        input = new int[][]{{2,11},{6,16},{11,16}};
        System.out.println(minMeetingRooms(input)); // 2

        input = new int[][]{{4, 5}, {2, 3}, {3, 6}, {5, 7}, {7, 8}};
        System.out.println(minMeetingRooms(input)); // 2

        input = new int[][]{{1, 4}, {2, 5}, {7, 9}};
        System.out.println(minMeetingRooms(input)); // 2
    }
}
