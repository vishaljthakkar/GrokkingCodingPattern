package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/meeting-rooms/description/
public class O4_MeetingRooms_252 {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end ) { this.start = start; this.end = end; }
    }
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2) return true;

        List<Interval> intervalList = new ArrayList<>();
        for(int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

//        Collections.sort(intervalList, (a, b) -> a.start - b.start);
//        intervalList.sort(Comparator.comparingInt(a -> a.start));
        intervalList.sort((a, b) -> Integer.compare(a.start, b.start));

        for(int i = 1; i < intervalList.size(); i++) {
            Interval first = intervalList.get(i - 1);
            Interval second = intervalList.get(i);
            if (second.start < first.end) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(canAttendMeetings(input));

        input = new int[][]{{7,10},{2,4}};
        System.out.println(canAttendMeetings(input));

        input = new int[][]{{7,10},{2,4}};
        System.out.println(canAttendMeetings(input));

        input = new int[][]{{7,10}};
        System.out.println(canAttendMeetings(input));

        input = new int[][]{{}};
        System.out.println(canAttendMeetings(input));

    }
}
