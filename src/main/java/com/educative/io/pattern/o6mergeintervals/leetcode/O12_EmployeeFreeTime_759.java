package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/employee-free-time/description/
public class O12_EmployeeFreeTime_759 {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start; this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    static class EmployeeInterval {
        Interval interval; // interval representing employees working hours
        int employeeIndex; // index of the list containing working hours of this employee
        int intervalIndex; // index of the interval in the employee list

        public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
            this.interval = interval; this.employeeIndex = employeeIndex; this.intervalIndex = intervalIndex;
        }
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        // heap to store one interval from each employee
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.interval.start, b.interval.start));

        // insert the first interval of each employee to the queue
        for(int i = 0; i < schedule.size(); i++) {
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }

        Interval previousInterval = minHeap.peek().interval;
        while(!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();
            // if previousInterval is not overlapping with the next interval, insert a free interval
            if (previousInterval.end < queueTop.interval.start) {
                result.add(new Interval(previousInterval.end, queueTop.interval.start));
                previousInterval = queueTop.interval;
            } else { // overlapping intervals, update the previousInterval if needed
                if (previousInterval.end < queueTop.interval.end) {
                    previousInterval = queueTop.interval;
                }
            }

            // if there are more interval available for the same employee, add their next interval
            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (employeeSchedule.size() > queueTop.intervalIndex + 1) {
                minHeap.offer(new EmployeeInterval(employeeSchedule.get(queueTop.intervalIndex + 1),
                        queueTop.employeeIndex, queueTop.intervalIndex + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = employeeFreeTime(input);
        System.out.print("Free Intervals: ");
        for(Interval interval : result) {
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        }
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(List.of(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(List.of(new Interval(6, 8))));
        result = employeeFreeTime(input);
        System.out.print("Free Intervals: ");
        for(Interval interval : result) {
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        }
        System.out.println();

//        input = new ArrayList<>();
//        input.add(new ArrayList<Interval>(List.of(new Interval(1, 3))));
//        input.add(new ArrayList<Interval>(List.of(new Interval(2, 4))));
//        input.add(new ArrayList<Interval>(List.of(new Interval(3, 5), new Interval(7, 9))));
//        result = employeeFreeTime(input);
//        System.out.print("Free Intervals: ");
//        for(Interval interval : result) {
//            System.out.print("[" + interval.start + ", " + interval.end + "] ");
//        }
//        System.out.println();
    }
}
