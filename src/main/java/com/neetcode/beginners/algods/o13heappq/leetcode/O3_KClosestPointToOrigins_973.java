package com.neetcode.beginners.algods.o13heappq.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class O3_KClosestPointToOrigins_973 {



    static class Point  implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y) { this.x = x; this.y = y; }

        @Override
        public int compareTo(Point that) {
//            double distanceOfThisFromOrigin = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
//            double distanceOfThatFromOrigin = Math.sqrt(Math.pow(that.x, 2) + Math.pow(that.y, 2));
//
//            return Double.compare(distanceOfThisFromOrigin, distanceOfThatFromOrigin);
            return (this.x * this.x + this.y * this.y) - (that.x * that.x + that.y * that.y);
        }

        public int[] toArray() {
            int[] result = new int[2];
            result[0] = this.x;
            result[1] = this.y;

            return result;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
//        PriorityQueue<Point> heap = new PriorityQueue<>((p1, p2) -> {
//            double distanceOfP1FromOrigin = Math.sqrt(Math.pow(p1.x, 2) + Math.pow(p1.y, 2));
//            double distanceOfP2FromOrigin = Math.sqrt(Math.pow(p2.x, 2) + Math.pow(p2.y, 2));
//
//            return Double.compare(distanceOfP1FromOrigin, distanceOfP2FromOrigin);
//        });

        PriorityQueue<Point> heap = new PriorityQueue<>(Point::compareTo);

        for(int[] point : points)
            heap.offer(new Point(point[0], point[1]));

        int[][] result = new int[k][];
        int index = 0;
        while(k > 0) {
            Point p = heap.poll();
            result[index] = p.toArray();

            index = index + 1;
            k = k - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][] { {1, 3}, {-2, 2} }, 1)));
        System.out.println(Arrays.deepToString(kClosest(new int[][] { {3, 3}, {5, -1}, {-2, 4} }, 2)));
    }

}
