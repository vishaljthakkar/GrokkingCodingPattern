package com.neetcode.beginners.algods.o15graphs.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class O3_ShortestPath_1091 {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        // Check if start and end cells are open
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        // 8 x 8 because question says the cell is 8 directionally connected.
//        int[][] visited = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0});
//        visited[0][0] = 1;
        visited[0][0] = true;
        // Since I explored this layer, which has just the start node. Starting length = 1;
        int length = 1;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for(int i = 0; i < queueLength; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                // Did I already reach my destination?
                if (r == grid.length - 1 && c == grid[0].length - 1) {
                    return length;
                }
                int[][] neighbors = new int[][] {
                        { r - 1, c - 1 },   // NW
                        { r - 1, c },       // N
                        { r - 1, c + 1 },   // NE
                        { r, c + 1 },       // E
                        { r, c - 1 },       // W
                        { r + 1, c + 1 },   // SE
                        { r + 1, c },       // S
                        { r + 1, c - 1 }    //SW
                };

                for (int[] neighbor : neighbors) {
                    int newR = neighbor[0];
                    int newC = neighbor[1];

                    // Out of the matrix bounds
                    if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length) continue;
                    // Already visited
//                    if (visited[newR][newC] == 1) continue;
                    if (visited[newR][newC]) continue;
                    // block on this cell indicated by '1' in the questions
                    if (grid[newR][newC] == 1) continue;

                    // All looks good. Add to the queue
                    queue.offer(neighbor);
//                    visited[newR][newC] = 1;
                    visited[newR][newC] = true;
                }
            }
            // All nodes at this layer are at same distance from the layer before.
            // That is why doing length + 1 after exploring all the nodes from this layer.
            length = length + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0,1},{1,0}};
        System.out.println(shortestPathBinaryMatrix(input));

        int[][] input2 = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(input2));

        int[][] input3 = new int[][]{{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(input3));

        int[][] input4 = new int[][]{
                {0,0,0,0,0,0,0,0,0},
                {0,1,1,0,0,0,0,0,0},
                {1,0,0,1,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1},
                {0,0,1,0,0,1,0,0,1},
                {0,1,0,1,0,0,1,1,0},
                {0,0,0,0,0,1,0,0,0},
                {0,1,0,1,0,0,1,0,0},
                {0,1,1,0,0,0,0,1,0}
        };
        System.out.println(shortestPathBinaryMatrix(input4));

    }
}
