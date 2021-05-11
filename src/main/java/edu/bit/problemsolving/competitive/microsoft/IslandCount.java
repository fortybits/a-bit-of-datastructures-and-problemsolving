package edu.bit.problemsolving.competitive.microsoft;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island.
 */
public class IslandCount {

    static final int ROW = 5, COL = 5;

    private static boolean isSafe(int[][] M, int row, int col, boolean[][] visited) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    private void DFS(int[][] M, int row, int col, boolean[][] visited) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int[] rowNbr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    // https://www.geeksforgeeks.org/find-number-of-islands/
    // The complexity of this approach is O(ROW x COL)
    public int countIslandsWithDFS(int[][] M) {
        // Make a bool array to mark visited cells. Initially all cells are unvisited
        boolean[][] visited = new boolean[ROW][COL];

        // Initialize count as 0 and traverse through the all cells of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    // If a cell with value 1 is not visited yet, then new island found.
                    // Visit all cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }
            }
        }
        return count;
    }


    // Using BFS approach and also understanding the difference
    // https://www.geeksforgeeks.org/islands-in-a-graph-using-bfs/
    // of when to use BFS or DFS  https://stackoverflow.com/questions/3332947/
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void BFS(int[][] mat, boolean[][] vis, int si, int sj) {
        // These arrays are used to get row and column numbers of 8 neighbours of a given cell
        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Simple BFS first step, we enqueue source and mark it as visited
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(si, sj));
        vis[si][sj] = true;

        // Next step of BFS. We take out items one by one from queue and enqueue their unvisited adjacents
        while (!q.isEmpty()) {
            int i = q.peek().first;
            int j = q.peek().second;
            q.remove();

            // Go through all 8 adjacent
            for (int k = 0; k < 8; k++) {
                if (isSafe(mat, i + row[k], j + col[k], vis)) {
                    vis[i + row[k]][j + col[k]] = true;
                    q.add(new Pair(i + row[k], j + col[k]));
                }
            }
        }
    }

    // This function returns number islands (connected components) in a graph.
    // It simply works as BFS for disconnected graph and returns count of BFS calls.
    static int countIslands(int[][] mat) {
        // Mark all cells as not visited
        boolean[][] vis = new boolean[ROW][COL];

        // Call BFS for every unvisited vertex
        // Whenever we see an unvisited vertex, we increment res (number of islands) also
        int res = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (mat[i][j] == 1 && !vis[i][j]) {
                    BFS(mat, vis, i, j);
                    res++;
                }
            }
        }
        return res;
    }
}