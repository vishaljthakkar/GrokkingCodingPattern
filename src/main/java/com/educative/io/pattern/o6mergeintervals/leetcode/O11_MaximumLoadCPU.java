package com.educative.io.pattern.o6mergeintervals.leetcode;
/*
We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.

Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
jobs are running at the same time i.e., during the time interval (2,4).

Jobs: [[6,7,10], [2,4,11], [8,12,15]]
Output: 15
Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.

Jobs: [[1,4,2], [2,4,1], [3,6,5]]
Output: 8
Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class O11_MaximumLoadCPU {
    static class Job {
        int cpuLoad;
        int start;
        int end;

        public Job(int start, int end, int cpuLoad) {
            this.start = start; this.end = end; this.cpuLoad = cpuLoad;
        }

        public int getCpuLoad() { return cpuLoad; }
        public int getStart() { return start; }
        public int getEnd() { return end; }

        @Override
        public String toString() {
            return "Job{" +
                    "cpuLoad=" + cpuLoad +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static int findMaxCpuLoad(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        for(int[] trip : jobs) {
            jobList.add(new Job(trip[0], trip[1], trip[2]));
        }

        jobList.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Job> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        int currentCPULoad = 0;
        int maxCPULoad = 0;
        for(Job job : jobList) {
            //remove all the jobs that have ended
            while(!heap.isEmpty() && job.getStart() > heap.peek().end) {
                currentCPULoad = currentCPULoad - heap.poll().getCpuLoad();
            }
            // add the current job in to the min heap.
            heap.offer(job);
            currentCPULoad = currentCPULoad + job.getCpuLoad();
            maxCPULoad = Math.max(currentCPULoad, maxCPULoad);
        }
        return maxCPULoad;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 4, 3}, {2, 5, 4}, {7, 9, 6}};
        System.out.println(findMaxCpuLoad(input)); // 7

        input = new int[][]{{6, 7, 10}, {2, 4, 11}, {8, 12, 15}};
        System.out.println(findMaxCpuLoad(input)); // 15

        input = new int[][]{{1, 4, 2}, {2, 4, 1}, {3, 6, 5}};
        System.out.println(findMaxCpuLoad(input)); // 8
    }
}
