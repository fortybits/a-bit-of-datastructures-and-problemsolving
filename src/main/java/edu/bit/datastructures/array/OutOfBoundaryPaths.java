package edu.bit.datastructures.array;

/**
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * You are allowed to move the ball to one of the four adjacent four cells in the
 * grid (possibly out of the grid crossing the grid boundary).
 * You can apply at most maxMove moves to the ball.
 * <p>
 * Given the five integers m, n, maxMove, startRow, startColumn,
 * return the number of paths to move the ball out of the grid boundary.
 * Since the answer can be very large, return it modulo 109 + 7.
 */
public class OutOfBoundaryPaths {

    // we can store the possible paths from each cell out of the boundary,
    // this would mean initialising the corners with 2 and adding one possible exit for each boundary cell
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0) {
            return 0;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // possible directions are
        final int MOD = 1000000007;

        int[][] count = new int[m][n];
        count[startRow][startColumn] = 1;
        int result = 0;

        for (int step = 0; step < maxMove; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }

        return result;
    }
}