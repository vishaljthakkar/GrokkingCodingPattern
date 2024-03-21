package com.educative.io.pattern.o4binarysearch.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class O11_PathWithMinimumEffort_1631 {
    int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    int rows, cols;

    public int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        int lo = -1, hi = (int) 1e6;

        while (hi > lo + 1) {
            int mid = lo + (hi - lo) / 2;
            if (ok(heights, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    // can we achieve minimum effort of 'mid'
    // FFFF'T'TTTTT
    private boolean ok(int[][] heights, int mid) {
        // just one row and col: 0 effort
        if (rows == 1 && cols == 1) {
            return true;
        }
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();

        visited[0][0] = true;
        q.offer(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dirs[i][0], newY = cur[1] + dirs[i][1];

                if (valid(newX, newY)
                        && !visited[newX][newY]
                        && Math.abs(heights[newX][newY] - heights[cur[0]][cur[1]]) <= mid) {
                    if (newX == rows - 1 && newY == cols - 1) {
                        return true;
                    }
                    visited[newX][newY] = true;
                    q.offer(new int[] { newX, newY });
                }
            }
        }

        return false;
    }

    private boolean valid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
