package edu.bit.datastructures.dp;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numberOfDistinctSubsequences(String s, String t) {
        if (s.isEmpty()) {
            return 0;
        }
        if (t.isEmpty()) {
            return 1;
        }
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        // for an empty string to be formed out of any string, we need to remove all (1 operation)
        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = 1;
        }
        // for any string to be found in an empty string is not possible, so we are defaulting to 0 ops
        // redundant in practice with 'int'
        for (int i = 1; i < t.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public int numDistinctRecursion(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        //Initially we fill array by -1, because ans cant be -1 even 0 can be an answer
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // and here we call the helper function
        return countDistinctHelper(s, t, s.length(), t.length(), dp);
    }

    private int countDistinctHelper(String s, String t, int m, int n, int[][] dp) {
        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        int inc = 0;
        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            inc = countDistinctHelper(s, t, m - 1, n - 1, dp);
        }
        int exc = countDistinctHelper(s, t, m - 1, n, dp);
        dp[m][n] = inc + exc;
        return dp[m][n];
    }
}