package com.neetcode.beginners.algods.o15graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class O2MatrixBFS {

    public static int bfs(int[][] grid) {

        int[][] visit = new int[grid.length][grid[0].length];
        Deque<int[]> queue = new ArrayDeque<>();

        // starting position in the grid
        queue.offer(new int[]{0, 0});
        visit[0][0] = 1;

        int length = 0;

        while(!queue.isEmpty()) {
            int queueLength = queue.size();
            for(int i = 0; i < queueLength; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                // did we reach the destination
                if (r == grid.length - 1 && c == grid[0].length - 1) {
                    return length;
                }
                // Explore neighbors
                int[][] neighbors = { {r, c + 1},  {r, c - 1},  {r + 1, c},  {r - 1, c} };
                for(int j = 0; j < neighbors.length; j++) {
                    int newR = neighbors[j][0];
                    int newC = neighbors[j][1];

                    // out of boundary of the matrix
                    if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length) continue;
                    // block on this new cell indicated by value '1' in questions
                    if (grid[newR][newC] == 1) continue;
                    // Already visited
                    if (visit[newR][newC] == 1) continue;

                    queue.offer(neighbors[j]);
                    visit[newR][newC] = 1;
                }
            }
            // Visited all the nodes in this layer of BFS. Increase the length.
            length = length + 1;
        }
        return length;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{ {0,0,0,0}, {1,1,0,0}, {0,0,0,1}, {0,1,0,0} };
        System.out.println(bfs(input));
    }
}
