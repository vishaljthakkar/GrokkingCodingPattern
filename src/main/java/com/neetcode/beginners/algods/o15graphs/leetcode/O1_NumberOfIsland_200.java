package com.neetcode.beginners.algods.o15graphs.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/description/
// DFS is faster than BFS in this problem.
public class O1_NumberOfIsland_200 {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int numIslands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // Saw an island. Let us see how large the island is?
                    numIslands += 1;
                    dfs(grid, i, j);

                }
            }
        }
        return numIslands;
    }

    public static void dfs(char[][] grid, int row, int col) {

        // matrix boundary conditions
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        // Hit the water? or did we already visit this cell
        if (grid[row][col] == '0') {
            return;
        }

        // Now that we entered here knowing it was '1' / land. Let us mark this node as visited, say '0' for water
        // So that when we explore 4 directions from here we do not come back to this cell.
        // NOTE: Here we are modifying the input grid as opposed to seprate visited array and
        // we are not back tracking as well
        // Reason being: We just want to explore how big the island is from where we  started and all 1's
        // are connected. Then we want to move to next totally disconnected 1 / land which is seprate from this one.
        grid[row][col] = '0';

        // Now explore in all 4 directions
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static int bfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        // Clockwise N -> E -> S -> W
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                // Found the start of the land
                if (grid[i][j] == '1') {
                    // increment the count.
                    numIslands += 1;
                    // Lets add it to the queue so that we can explore
                    queue.offer(new int[]{i, j});
                    // Mark this as visited.
                    grid[i][j] = '0';
                    while(!queue.isEmpty()) {
                        // Get the next cell and check the boundary conditions
                        int[] current = queue.poll();
                        // Now explore in all 4 directions
                        for(int[] dir : directions) {
                            int newRow = current[0] + dir[0];
                            int newCol = current[1] + dir[1];
                            // matrix boundary conditions
                            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                                continue;
                            }
                            // Hit the water? or did we already visit this cell
                            if (grid[newRow][newCol] == '0') {
                                continue;
                            }
                            queue.offer(new int[]{ newRow, newCol });
                            grid[newRow][newCol] = '0';
                        }
                    }
                }
            }
        }
        return numIslands;
    }

    public static void main(String[] args) {
        char[][]input =  new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        System.out.println(numIslands(input));
        // Same input because we are modifying the input grid above.
        char[][]input2 =  new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        System.out.println(bfs(input2));
    }
}
