package edu.bit.datastructures.recursion;

import java.util.Arrays;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * <p>
 * Input: rowIndex = 1
 * Output: [1,1]
 */
public class PascalsTriangle {

    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }

        return Arrays.asList(arr);
    }

    // indexth at 1
    public int findPascalNumber(int i, int j) {
        if (i == 1 || j == 1) return 1;
        if (i == j) return 1;
        return findPascalNumber(i - 1, j - 1) + findPascalNumber(i - 1, j);
    }
}