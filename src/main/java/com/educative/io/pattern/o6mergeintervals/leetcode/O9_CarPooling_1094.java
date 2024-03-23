package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/car-pooling/
public class O9_CarPooling_1094 {
    static class Trip {
        int numPassengers;
        int start;
        int end;

        public Trip(int numPassengers, int start, int end) {
            this.numPassengers = numPassengers; this.start = start; this.end = end;
        }

        public int getNumPassengers() { return numPassengers; }
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        // Create list of Trip objects
        List<Trip> tripList = new ArrayList<>();
        for(int[] trip : trips) {
            tripList.add(new Trip(trip[0], trip[1], trip[2]));
        }

        // Sort the trip based on the start time.
        tripList.sort((a, b) -> Integer.compare(a.start, b.start));

        // store elements in heap based on ascending order of trip end time. why?
        // Because we want to compare trip with the trip that ends first so that we can add to our capacity
        // if the trip in the heap has ended.
        PriorityQueue<Trip> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        // Add the first trip to the heap and see if we exhausted capacity
        Trip firstTrip = tripList.get(0);
        capacity = capacity - firstTrip.getNumPassengers();
        if (capacity < 0) return false;
        heap.offer(firstTrip);

        for(int i = 1; i < tripList.size(); i++) {
            Trip currentTrip = tripList.get(i);
            // Check if compared to the current trip the trips in the heap are ended or not.
            // If ended, remove it from the heap and reclaim our capacity
            while (!heap.isEmpty() && currentTrip.start >= heap.peek().end) {
                Trip completedTrip = heap.poll();
                capacity = capacity + completedTrip.getNumPassengers();
            }
            // Add current trip to the heap and check if we exhausted capacity
            capacity = capacity - currentTrip.getNumPassengers();
            if (capacity < 0) return false;
            heap.offer(currentTrip);
        }

        // our capacity should be positive or max zero.
        return capacity >= 0;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{2, 1, 5}, {3, 3, 7}};
        System.out.println(carPooling(input, 4)); // false

        input = new int[][]{{2, 1, 5}, {3, 3, 7}};
        System.out.println(carPooling(input, 5)); // true

        input = new int[][]{{3, 2, 8}, {4, 4, 6}, {10, 8, 9}};
        System.out.println(carPooling(input, 11)); // true

        input = new int[][]{{9, 0, 1}, {3, 3, 7}};
        System.out.println(carPooling(input, 4)); // false

        input = new int[][]{{7, 5, 6}, {6, 7, 8}, {10, 1, 6}};
        System.out.println(carPooling(input, 16)); // false
    }
}
