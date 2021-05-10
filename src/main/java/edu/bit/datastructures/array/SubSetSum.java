package edu.bit.datastructures.array;

/**
 * Given a set of non-negative integers, and a value sum,
 * determine if there is a subset of the given set with sum equal to given sum.
 */
public class SubSetSum {

    // using recursion starting from the last element
    boolean isSubsetSumRecur(int[] set, int n, int sum) {
        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        // If last element is greater than sum, then ignore it
        if (set[n - 1] <= sum) {
            return isSubsetSumRecur(set, n - 1, sum) ||
                    isSubsetSumRecur(set, n - 1, sum - set[n - 1]);
        }
        return isSubsetSumRecur(set, n - 1, sum);
    }

    boolean isSubsetSum(int[] nums, int sum) {
        int n = nums.length;
        // assuming dp[i][j] means whether the specific sum j can be gotten from the first i numbers
        boolean[][] dp = new boolean[n + 1][sum + 1];

        dp[0][0] = true;
        // If sum is 0, then answer is true
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true;
        }
        // If sum is not 0 and set is empty, then answer is false
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
            }
        }

        return dp[n][sum];
    }

    // space optimisation for persisting the value dp for each possible sum less than or equal to input
    boolean isSubsetSumSpaceOptimised(int[] nums, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }
}