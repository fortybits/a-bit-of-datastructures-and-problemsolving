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
    static int maxN = 20;
    static int maxSum = 50;
    static int minSum = 50;
    static int base = 50;
    static int[][] dp = new int[maxN][maxSum + minSum];
    static boolean[][] v = new boolean[maxN][maxSum + minSum];

    int findSubsetCounts(int[] arr, int i, int required_sum, int n) {
        // Base case
        if (i == n) {
            if (required_sum == 0)
                return 1;
            else
                return 0;
        }

        // If the state has been solved before
        // return the value of the state
        if (v[i][required_sum + base])
            return dp[i][required_sum + base];

        // Setting the state as solved
        v[i][required_sum + base] = true;

        // Recurrence relation
        dp[i][required_sum + base] =
                findSubsetCounts(arr, i + 1, required_sum, n) +
                        findSubsetCounts(arr, i + 1, required_sum - arr[i], n);
        return dp[i][required_sum + base];
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