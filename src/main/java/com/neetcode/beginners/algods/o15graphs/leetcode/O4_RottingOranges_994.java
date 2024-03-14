package com.neetcode.beginners.algods.o15graphs.leetcode;

// https://leetcode.com/problems/rotting-oranges/

import java.util.ArrayDeque;
import java.util.Queue;

// This problem is different than earlier 3 problems where we always start from the
// zeroth node.
// Here rotten oranges can be anywhere in the grid and can be more than one.
// Plus the problems says that at every tick of the time (starting with 0 in cells with rotten oranges)
// neighboring fresh oranges will rot. It is like disease spreading from rotten oranges outwards.
// Now, fresh oranges that are dispersed will have different time to get rotten and will not be uniformly
// increasing. Which means there is a need for us to store cell specific data.

public class O4_RottingOranges_994 {
    public static final int EMPTY = 0;
    public static final int FRESH = 1;
    public static final int ROTTEN = 2;

    class CellData {
        private int x;
        private int y;
        private int minute;
        private boolean visited;

        public CellData(int x, int y, int minute, boolean visited) {
            this.x = x;
            this.y = y;
            this.minute = minute;
            this.visited = visited;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = -1;
        Queue<CellData> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // Find the rotten oranges and add it to the queue with time = zero minutes and
        // visited = true
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ROTTEN) {
                    queue.offer(new CellData(i, j, 0, true));
                    visited[i][j] = true;
                }
            }
        }


        // This is important because you cannot have condition that you reached the last cell and send the result out
        // from the last cell. We still have to check if we have any lingering fresh oranges after the queue is empty.
        // So we have to record the last cell value in the loop and return it if all is good.
        int minuteHere = 0;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            // Take the rotten oranges from the queue and start exploring its neighbors
            for (int i = 0; i < queueLength; i++) {
                CellData cellData = queue.poll();
                int r = cellData.getX();
                int c = cellData.getY();
                minuteHere = cellData.getMinute();

                int[][] neighbors = {
                        {r - 1, c},
                        {r + 1, c},
                        {r, c - 1},
                        {r, c + 1}
                };

                for (int[] neighbor : neighbors) {
                    int newR = neighbor[0];
                    int newC = neighbor[1];

                    // matrix boundary condition
                    if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length)
                        continue;
                    // Already visited
                    if (visited[newR][newC])
                        continue;
                    // The cell is either empty or has rotten oranges. How can you rot which is
                    // already rotten?
                    if (grid[newR][newC] == EMPTY || grid[newR][newC] == ROTTEN)
                        continue;
                    queue.offer(new CellData(newR, newC, minuteHere + 1, true));
                    visited[newR][newC] = true;
                    grid[newR][newC] = ROTTEN;
                }
            }
        }
        result = minuteHere;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == FRESH) {
                    return -1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input2 = new int[][]{{2, 1, 1}, {1, 1,0}, {0, 1, 1}};
        System.out.println(new O4_RottingOranges_994().orangesRotting(input2));
        int[][] input1 = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(new O4_RottingOranges_994().orangesRotting(input1));
    }
}
