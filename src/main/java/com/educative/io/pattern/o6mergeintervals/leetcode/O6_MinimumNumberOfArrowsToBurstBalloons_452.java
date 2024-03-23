package com.educative.io.pattern.o6mergeintervals.leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
public class O6_MinimumNumberOfArrowsToBurstBalloons_452 {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;

        List<Interval> intervalList = new ArrayList<>();
        for (int[] interval : points) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        intervalList.sort((a, b) -> Integer.compare(a.end, b.end));

        Interval firstBalloon = intervalList.get(0);
        int arrayPosition = firstBalloon.end;
        int arrowCount = 1;

        for (int i = 1; i < intervalList.size(); i++) {
            if (arrayPosition >= intervalList.get(i).start) {
                // overlapping balloons/interval current arrow count is sufficient to burst
                // ballons
                continue;
            }
            arrayPosition = intervalList.get(i).end;
            arrowCount = arrowCount + 1;
        }
        return arrowCount;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(input)); // 2

        input = new int[][]{{1,2},{3,4},{5, 6},{7,8}};
        System.out.println(findMinArrowShots(input)); // 4
    }
}
