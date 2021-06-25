package edu.bit.datastructures.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 * <p>
 * Now rain starts to fall. At time t, the depth of the water everywhere is t.
 * You can swim from a square to another 4-directionally adjacent square if and only if the
 * elevation of both squares individually are at most t. You can swim infinite distance in zero time.
 * Of course, you must stay within the boundaries of the grid during your swim.
 * <p>
 * You start at the top left square (0, 0). What is the least time until you can reach
 * the bottom right square (N-1, N-1)?
 */
public class SwimInRisingWater {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int swimInWater(int[][] grid) {
        int time = 0;
        int N = grid.length;
        Set<Integer> visited = new HashSet<>();
        while (!visited.contains(N * N - 1)) {
            visited.clear();
            dfs(grid, 0, 0, time, visited);
            time++;
        }
        return time - 1;
    }

    private void dfs(int[][] grid, int i, int j, int time, Set<Integer> visited) {
        if (i < 0 || i > grid.length - 1
                || j < 0 || j > grid[0].length - 1
                || grid[i][j] > time || visited.contains(i * grid.length + j)) {
            return;
        }
        visited.add(i * grid.length + j);
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], time, visited);
        }
    }
}
