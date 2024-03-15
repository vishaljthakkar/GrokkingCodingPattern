package com.neetcode.beginners.algods.o16dynamicprogramming.leetcode;

import java.util.Arrays;
// https://leetcode.com/problems/unique-paths/description/
public class O3_UniquePaths_62_2D {

    public int uniquePaths(int m, int n) {
        // // Time Limit Exceeded. But works for smaller inputs.
        // return bruteForce(0, 0, m, n);

        // This is an accepted solution
        // return memoization(0, 0, m, n, new int[m][n]);

        // Works as well filling known cases from bottom
        // return dynamicProgramming(m ,n);
        // Works as well filling known cases from top
        // return dynamicProgrammingFromTop(m, n);

        // In the above solution we create m x n space. But if you think do we really
        // need it.
        // When we are calculating all we need is the one row in the bottom and one
        // ""coloumn cell""
        // of that row. X = prevRow[j] + currentRow[j + 1]
        // currentRow -> | | | X | 1 |
        // ------------------
        // prevRow -> | 1 | 1 | 1 | 1 |
         return dynamicProgrammingImprovedMemory(m, n);
    }

    // Time Limit Exceeded. But works for smaller inputs.
    public static int bruteForce(int r, int c, int rowLength, int colLength) {
        if (r == rowLength || c == colLength) {
            return 0;
        }

        if (r == rowLength - 1 && c == colLength - 1) {
            return 1;
        }

        return bruteForce(r + 1, c, rowLength, colLength) +
                bruteForce(r, c + 1, rowLength, colLength);
    }

    public static int memoization(int r, int c, int rowLength, int colLength, int[][] cache) {
        if (r == rowLength || c == colLength) {
            return 0;
        }

        if (cache[r][c] > 0) {
            return cache[r][c];
        }

        if (r == rowLength - 1 && c == colLength - 1) {
            return 1;
        }

        cache[r][c] = memoization(r + 1, c, rowLength, colLength, cache) +
                memoization(r, c + 1, rowLength, colLength, cache);
        return cache[r][c];
    }

    // botom up approach. Filling the base case and bottom row and last column
    // first.
    public int dynamicProgramming(int m, int n) {
        int[][] lookup = new int[m][n];

        // In the rightmost column we only have one way and that is to go down. Mark
        // that column with 1.
        for (int i = 0; i < m; i++) {
            lookup[i][n - 1] = 1;
        }

        // In the bottom row we only have one way to go and that is right. Mark that row
        // with 1.
        for (int j = 0; j < n; j++) {
            lookup[m - 1][j] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                lookup[i][j] = lookup[i + 1][j] + lookup[i][j + 1];
            }
        }
        return lookup[0][0];
    }

    // top down approach. Filling the first case and first row and first column
    // first.
    public int dynamicProgrammingFromTop(int m, int n) {
        int[][] lookup = new int[m][n];

        // first column
        for (int i = 0; i < m; i++) {
            lookup[i][0] = 1;
        }

        // first row
        for (int j = 0; j < n; j++) {
            lookup[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                lookup[i][j] = lookup[i - 1][j] + lookup[i][j - 1];
            }
        }
        return lookup[m - 1][n - 1];
    }

    public int dynamicProgrammingImprovedMemory(int m, int n) {
        int[] prevRow = new int[n];

        // I know by default it is zero. This is to just be explicit in our calculation
        Arrays.fill(prevRow, 0);

        for (int i = m - 1; i >= 0; i--) {
            int[] currentRow = new int[n];
            // Just like above we know that last column of any row has only one option and
            // that is to go down
            currentRow[n - 1] = 1;
            for (int j = n - 2; j >= 0; j--) {
                currentRow[j] = prevRow[j] + currentRow[j + 1];
            }
            prevRow = currentRow;
        }
        return prevRow[0];
    }
}
