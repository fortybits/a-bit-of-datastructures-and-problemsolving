package edu.bit.datastructures.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] of length N and an integer X,
 * the task is to find the number of subsets with sum equal to X.
 */
public class CountSubsetsWithSumK {

    // considering that we can identify a sub optimal problem and we can apply that recursively,
    // then we can formulate it into a dp problem as
    // dp[i][K] = dp[i – 1][K – arr[i]] + dp[i – 1][K]
    // ^^ count with the value and count without the value
    int findSubsetCounts(int[] arr, int i, int K, int n) {
        if (i == n) {
            return K == 0 ? 1 : 0;
        }

        int[][] countData = new int[arr.length][K];
        boolean[][] visited = new boolean[arr.length][K];

        // If the state has been solved before return the value of the state
        if (visited[i][K]) {
            return countData[i][K];
        }

        // Setting the state as solved
        visited[i][K] = true;

        // Recurrence relation
        countData[i][K] = findSubsetCounts(arr, i + 1, K, n) +
                findSubsetCounts(arr, i + 1, K - arr[i], n);
        return countData[i][K];
    }


    int findSubArraySumToKCounts(int[] nums, int sum) {
        // HashMap to store number of sub-arrays starting from index zero having particular value of sum.
        Map<Integer, Integer> prevSum = new HashMap<>();
        int res = 0;
        int currentSum = 0;      // Sum of elements so far.

        for (int val : nums) {
            // Add current element to sum so far.
            currentSum += val;

            // If currentSum is equal to desired sum, then a new sub-array is found.
            // So increase count of sub-arrays.
            if (currentSum == sum) {
                res++;
            }

            // if currentSum exceeds given sum by (currentSum - sum).
            // Find number of sub-arrays having this sum and exclude those sub-arrays
            // from currentSum by increasing count by same amount.
            if (prevSum.containsKey(currentSum - sum)) {
                res += prevSum.get(currentSum - sum);
            }

            // Add currentSum value to count of different values of sum.
            prevSum.merge(currentSum, 1, Integer::sum);
        }

        return res;
    }
}