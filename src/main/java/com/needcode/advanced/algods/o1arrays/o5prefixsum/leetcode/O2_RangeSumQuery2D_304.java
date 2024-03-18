package com.needcode.advanced.algods.o1arrays.o5prefixsum.leetcode;

import java.util.Arrays;
// https://leetcode.com/problems/range-sum-query-2d-immutable/submissions/1206939789/
// leetcode editorial is better than  this video but see both for better understanding.
// https://www.youtube.com/watch?v=KE8MQuwE2yA
public class O2_RangeSumQuery2D_304 {
    private int[][]  sumMatrix;

    public O2_RangeSumQuery2D_304(int[][] matrix) {
        int  m = matrix.length;
        int n = matrix[0].length;
        // We increased the size of the matrix because it is easier to do calculation and avoid usage of
        // if else coditions in the code for boundary condition.
        sumMatrix = new int[m + 1][n + 1];

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                // current cell  = cell to the left + cell above - cell diagonal above corner  since we calculated twice.
                // logic here is we are calculating  running sum of the area ending in this cell with start as origin cell.
                sumMatrix[r + 1][c + 1] = sumMatrix[r + 1][c] + sumMatrix[r][c + 1] - sumMatrix[r][c] + matrix[r][c];
            }
        }
        System.out.println(Arrays.deepToString(sumMatrix));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // This is because we have increased our sumMatrix by one row and one col.
        row1 = row1 + 1; row2 = row2 + 1; col1 = col1 + 1; col2 = col2 + 1;

        // Since we have precomputed area ending at each cell in the constructor, we have to eliminate areas that are not part
        // of this given indexes. Now that topleft corner is eliminated twice we have to add it back.
        // Draw the diagram to work it out.
        int aboveArea = sumMatrix[row1 - 1][col2];
        int leftArea = sumMatrix[row2][col1 - 1];
        int entireArea = sumMatrix[row2][col2];
        int topLeftCornerArea = sumMatrix[row1 - 1][col1 - 1];

        return entireArea - leftArea - aboveArea + topLeftCornerArea;
    }

    public static void main(String[] args) {
        O2_RangeSumQuery2D_304 o2RangeSumQuery2D304 = new O2_RangeSumQuery2D_304(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}}
        );
        System.out.println(o2RangeSumQuery2D304.sumRegion(2, 1, 4, 3));
        System.out.println(o2RangeSumQuery2D304.sumRegion(1, 1, 2, 2));
        System.out.println(o2RangeSumQuery2D304.sumRegion(1, 2, 2, 4));

        O2_RangeSumQuery2D_304 o2RangeSumQuery2D3041 = new O2_RangeSumQuery2D_304(new int[][]{
                {-1}
        });
        System.out.println(o2RangeSumQuery2D3041.sumRegion(0,0,0,0));
    }
}
