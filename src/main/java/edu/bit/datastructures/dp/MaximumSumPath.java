package edu.bit.datastructures.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 1  2  3  4  5
 * 6  7  8  9  10
 * 11 12 13 14 15
 * 16 17 18 19 20
 * source 0,0
 * destination m, n
 * >> direction(right, bottom)
 * >> eligibility()?
 * <p>
 * 1  2  3  4  5
 * 6  -7  10000  9  10
 * 11 12 -13 14 15
 * -16 17 -18 19 20
 * <p>
 * 990
 * 10000 9 10
 * -13 14 15
 * -18 19 20
 * <p>
 * 25
 * 4 5
 * 9 10
 * 14 15
 * 19 20
 * <p>
 * 1,6,11,12,17,-18,19,20
 */
public class MaximumSumPath {


    int[][] directions = {{0, 1}, {1, 0}};

    public Path maximumSumPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> elementsWithMaxSum = new ArrayList<>();
        elementsWithMaxSum.add(matrix[0][0]);
        int maxSum = maximumSumPathOverload(0, 0, matrix[0][0], m, n, matrix, elementsWithMaxSum);
        return new Path(maxSum, elementsWithMaxSum);
    }

    private int maximumSumPathOverload(int x, int y, int sum, int m, int n, int[][] matrix, List<Integer> eligibleElements) {
        if (!eligibleCoordinates(x, y)) return sum;

        if (x == m && y == n) {
            return sum;
        }

        int rightElement = matrix[x][y + 1];
        int bottomElement = matrix[x + 1][y];

        int rightSum = maximumSumPathOverload(x, y + 1, sum + rightElement, m, n, matrix, eligibleElements);
        int bottomSum = maximumSumPathOverload(x + 1, y, sum + bottomElement, m, n, matrix, eligibleElements);

        if (rightSum > bottomSum) {
            eligibleElements.add(rightElement);
            return rightSum;
        } else {
            eligibleElements.add(bottomElement);
            return bottomSum;
        }
    }

    boolean eligibleCoordinates(int m, int n) {
        return false;
    }


    class Path {
        int sum;
        List<Integer> elements;

        public Path(int sum, List<Integer> elements) {
            this.sum = sum;
            this.elements = elements;
        }
    }
}