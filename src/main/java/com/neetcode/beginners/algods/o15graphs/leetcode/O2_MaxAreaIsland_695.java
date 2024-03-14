package com.neetcode.beginners.algods.o15graphs.leetcode;

// https://leetcode.com/problems/max-area-of-island/

public class O2_MaxAreaIsland_695 {
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int area = 0;
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area += dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                    // Reset area for next island exploration, Otherwise we will keep adding to it.
                    area = 0;
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        // Hit water? Or we already visited
        if (grid[row][col] == 0) {
            return 0;
        }

        // current cell area
        int totalArea = 1;
        // mark this cell as visited before we go about exploring neighbors
        grid[row][col] = 0;


        totalArea += dfs(grid, row + 1, col);
        totalArea += dfs(grid, row - 1, col);
        totalArea += dfs(grid, row, col + 1);
        totalArea += dfs(grid, row, col - 1);

        return totalArea;
    }

    public static void main(String[] args) {
        int[][] input1 = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(input1));
    }
}
