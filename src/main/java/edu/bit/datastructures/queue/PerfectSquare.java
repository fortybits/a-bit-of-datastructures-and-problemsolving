package edu.bit.datastructures.queue;

import java.util.Arrays;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * <p>
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class PerfectSquare {

    // Using DP seems similar but the idea shall be similar that given a number 'i' a relation with another number 'j' can
    // be established if sum of square of both these numbers is less than or equal to N, while we would also have to
    // find all squares until N which shall help in reverse computing
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // set all as max int

        dp[0] = 0; // fallback of numbers

        for (int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

}