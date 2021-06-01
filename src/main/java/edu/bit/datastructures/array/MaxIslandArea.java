package edu.bit.datastructures.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n binary matrix grid.
 * An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxIslandArea {

    private int areaOfIsland(int[][] mat, boolean[][] vis, int si, int sj, int ROW, int COL) {
        int[] row = {-1, 0, 0, 1};
        int[] col = {0, 1, -1, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{si, sj});
        vis[si][sj] = true;
        int area = 1;
        // Next step of BFS. We take out items one by one from queue and enqueue their unvisited adjacents
        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            q.remove();

            // Go through all 8 adjacent
            for (int k = 0; k < row.length; k++) {
                if (isSafe(mat, i + row[k], j + col[k], vis, ROW, COL)) {
                    vis[i + row[k]][j + col[k]] = true;
                    q.add(new int[]{i + row[k], j + col[k]});
                    area++;
                }
            }
        }
        return area;
    }

    private boolean isSafe(int[][] M, int row, int col, boolean[][] visited, int ROW, int COL) {
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (M[row][col] == 1 && !visited[row][col]);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    maxArea = Math.max(maxArea, areaOfIsland(grid, vis, i, j, row, col));
                }
            }
        }
        return maxArea;
    }
}
