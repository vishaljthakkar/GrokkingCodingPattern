package com.neetcode.beginners.algods.o16dynamicprogramming;

// Count unique path in an mxn grid. Starting location(0,0) ending location (grid.length -1 , grid[0].length -1)
// You can only go down or right.

public class CountPath_2D {
    // Brute Force - O(2 ^(m + n)), Space O(m + n)

    public static int bruteForce(int r, int c, int rowLength, int colLength) {

        if (r == rowLength || c == colLength) {
            return 0;
        }

        if (r == rowLength - 1 && c == colLength -1) {
            return 1;
        }

        // What are my options? I can go right or I can go down
        return bruteForce(r, c + 1, rowLength, colLength) +
        bruteForce(r + 1, c , rowLength, colLength);
    }

    // Memoization - Time and Space O(n * m)
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

        cache[r][c] = memoization(r, c + 1, rowLength, colLength, cache) +
                      memoization(r + 1, c, rowLength, colLength, cache);

        return cache[r][c];
    }

    public static int dynamicProgramming(int r, int c, int rowLength, int colLength) {
        int[] prevRow = new int[colLength];

        for(int i = rowLength - 1; i >= 0; i--) {
            int[] currentRow = new int[colLength];

            currentRow[colLength - 1] = 1;

            for(int j = colLength - 2; j >= 0; j--) {
                //currentCell =    down      +     right
                currentRow[j] = prevRow[j] + currentRow[j + 1];
            }
            prevRow = currentRow;
        }
        return prevRow[0];
    }

    public static void main(String[] args) {
        System.out.println(bruteForce(0, 0, 4, 4));
        System.out.println(memoization(0, 0, 4, 4, new int[4][4]));
        System.out.println(dynamicProgramming(0, 0, 4, 4));
    }
}
