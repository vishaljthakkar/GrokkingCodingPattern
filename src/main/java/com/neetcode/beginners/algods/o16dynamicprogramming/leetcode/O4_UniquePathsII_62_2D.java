package com.neetcode.beginners.algods.o16dynamicprogramming.leetcode;
// https://leetcode.com/problems/unique-paths-ii/
public class O4_UniquePathsII_62_2D {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If start and end is 1 / obstacle we cannot proceed
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m -1][n - 1] == 1) return 0;

        // Works but we are hitting TLE.
        // return bruteForce(obstacleGrid, 0, 0, m, n);

        // Works but runtime is 5 ms
        // int[][] cache = new int[m][n];
        // return memoization(obstacleGrid, 0, 0, m, n, cache);

        // Due to the nature of this problem, unlike unique path we cannot build from bottom to up.
        // Reason being if there is an obstacle then we just cannot go down or right from that point on.
        // How do you determine if you are coming from bottom then?
        return dynamicProgrammingTopToDown(obstacleGrid, m, n);

    }

    public int bruteForce(int[][] obstacleGrid, int r, int c, int m, int n) {
        // Out of boundary
        if (r == m || c == n)
            return 0;

        // Reached destination?
        if (r == m - 1 && c == n - 1)
            return 1;

        // Hitting an obstacle?
        if (obstacleGrid[r][c] == 1)
            return 0;

        return bruteForce(obstacleGrid, r + 1, c, m, n) +
                bruteForce(obstacleGrid, r, c + 1, m, n);
    }

    public int memoization(int[][] obstacleGrid, int r, int c, int m, int n, int[][] cache) {
        // Out of boundary
        if (r == m || c == n) {
            return 0;
        }

        if (cache[r][c] > 0) {
            return cache[r][c];
        }

        // Reached destination?
        if (r == m - 1 && c == n - 1)
            return 1;

        // Hitting an obstacle?
        if (obstacleGrid[r][c] == 1)
            return 0;

        cache[r][c] =  memoization(obstacleGrid, r + 1, c, m, n, cache) +
                memoization(obstacleGrid, r, c + 1, m, n, cache);

        return cache[r][c];

    }

    public int dynamicProgrammingTopToDown(int[][] grid, int m , int n) {
        int[][] lookup = new int[m][n];

        for(int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                break;
            } else {
                lookup[i][0] = 1;
            }
        }
        for(int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                break;
            } else {
                lookup[0][j] = 1;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    lookup[i][j] = 0;
                } else {
                    lookup[i][j] = lookup[i - 1][j] + lookup[i][j - 1];
                }
            }
        }
        return lookup[m - 1][n - 1];
    }
}
