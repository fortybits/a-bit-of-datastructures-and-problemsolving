package edu.bit.datastructures.search;

/**
 * A peak element in a 2D grid is an element that is strictly greater than all of its
 * adjacent neighbors to the left, right, top, and bottom.
 * <p>
 * Given a 0-indexed m x n matrix mat where no two adjacent cells are equal,
 * find any peak element mat[i][j] and return the length 2 array [i,j].
 * <p>
 * You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.
 * <p>
 * You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
 */
public class FindPeakElementsII {
    public int[] findPeakGrid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0;
        int hi = m - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            int max_row = 0;
            for (int i = 0; i < n; ++i) {
                if (matrix[max_row][mid] < matrix[i][mid])
                    max_row = i;
            }
            if ((mid == 0 || matrix[max_row][mid] > matrix[max_row][mid - 1]) &&
                    (mid == m - 1 || matrix[max_row][mid] > matrix[max_row][mid + 1]))
                return new int[]{max_row, mid};
            else if (mid > 0 && matrix[max_row][mid - 1] > matrix[max_row][mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return new int[]{-1, -1};
    }
}