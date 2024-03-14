package com.neetcode.beginners.algods.o15graphs;

public class O1MatrixDFS {

    // count path Back tracking
    int dfs(int[][] grid, int r, int c, int[][] visit) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        // First 3 conditions checks if we are out of bound of the given matrix.
        // 4th condition checks if we have already visited this node/cell
        // 5th condition checks if the given grid cell has some blocks (indicated by 1 in the problem)
        if (Math.min(r, c) < 0 || r == ROWS || c == COLS || visit[r][c] == 1 || grid[r][c] == 1)
            return 0;

        // Reached the last cell
        if (r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        // Mark the cell as visited
        visit[r][c] = 1;

        int count = 0;
        // Going in clock wise direction starting from North/Up
        count += dfs(grid, - 1, c, visit);
        count += dfs(grid, r, c + 1, visit);
        count += dfs(grid, r + 1, c, visit);
        count += dfs(grid, r, c - 1, visit);

        // Unmark the cell as visited
        visit[r][c] = 0;

        return count;
    }
}
