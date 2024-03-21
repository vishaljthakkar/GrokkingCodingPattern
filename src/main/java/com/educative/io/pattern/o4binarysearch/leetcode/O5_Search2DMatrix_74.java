package com.educative.io.pattern.o4binarysearch.leetcode;

public class O5_Search2DMatrix_74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;

        int cols = matrix[0].length;
        if (cols == 0) return false;

        // We are giving responsibility to high.
        // Which means we need to build our question for high to move left
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

    // F F F F 'T' T T T T T
    public static boolean ok(int[][] matrix, int mid, int target) {
        int cols = matrix[0].length;
        return matrix[mid / cols][mid % cols] >= target;
    }

    public static void main(String[] args) {
        int[][] input = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        System.out.println(searchMatrix(input, 3));
        System.out.println(searchMatrix(input, 13));
        // true
        // false
    }
}
