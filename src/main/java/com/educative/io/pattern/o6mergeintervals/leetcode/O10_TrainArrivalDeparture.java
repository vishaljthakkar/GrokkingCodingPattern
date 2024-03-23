package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
/*
Problem 2: Given a list of intervals representing the arrival and departure times of trains to a
train station, our goal is to find the minimum number of platforms required for the train station so that no train has to wait.
 */
public class O10_TrainArrivalDeparture {
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

    private static int countPlatforms(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for(int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        intervalList.sort((a, b) -> Integer.compare(a.start, b.start));
        // Min heap based on end time
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        Interval first = intervalList.get(0);
        // Add the first train tp the heap
        heap.offer(first);
        for(int i = 1; i < intervalList.size(); i++) {
            // If the departure time of the train in the heap has no overlap with this train
            // Remove the train schedule in the heap as that train schedule will not contribute to our platform count
            // That schedule has ended.
            Interval currentTrainSchedule = intervalList.get(i);
            if (currentTrainSchedule.start >= heap.peek().end) {
                heap.poll();
            }
            heap.offer(currentTrainSchedule);
        }
        //All the conflicting meetings are part of the heap.
        return heap.size();

    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{900, 910}, {940, 1200}, {950, 1120}, {1100, 1130}, {1500, 1900}, {1800, 2000}};
        System.out.println(countPlatforms(input));
    }
}
