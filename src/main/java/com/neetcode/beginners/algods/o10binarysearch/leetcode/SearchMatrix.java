package com.neetcode.beginners.algods.o10binarysearch.leetcode;

// https://leetcode.com/problems/search-a-2d-matrix/submissions/482736812/
public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;

        int cols = matrix[0].length;
        if (cols == 0) return false;

        int low = -1;
        int high = rows * cols - 1;

        while(low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (ok(matrix, mid, target)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return matrix[high / cols][high % cols] == target;
    }

    public static boolean ok(int[][] matrix, int idx, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        return matrix[idx / cols][idx % cols] >= target;
    }

}
