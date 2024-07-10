package edu.bit.datastructures.dp;

/**
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * There are n stones arranged in a row. On each player's turn,
 * they can remove either the leftmost stone or the rightmost stone from the row
 * and receive points equal to the sum of the remaining stones' values in the row.
 * The winner is the one with the higher score when there are no stones left to remove.
 * <p>
 * Bob found that he will always lose this game (poor Bob, he always loses),
 * so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.
 * <p>
 * Given an array of integers stones where stones[i] represents the value of the ith stone from the left,
 * return the difference in Alice and Bob's score if they both play optimally.
 */
public class StoneGameVII {

    Integer[][] memo;
    int[] preSum;

    public int stoneGameVII(int[] stones) {
//        result(stones[0 .. n]) = max(
//                sum(stones[1 .. n]) - result(stones[1 .. n]),
//        sum(stones[0 .. n - 1]) - result(stones[0 .. n - 1]))

        // prefix sum ==> sum(stones[i .. j]) == prefix[j] - prefix[i - 1]
        int n = stones.length;
        int[] prefix = new int[n];
        int[] dp = new int[n];

        for (var i = 0; i < n; i++) {
            prefix[i] = stones[i] + (i > 0 ? prefix[i - 1] : 0);
        }

        for (var i = 0; i < n - 1; i++) {
            dp[i] = Math.max(stones[i], stones[i + 1]);
        }

        for (var l = 2; l < n; l++) {
            // length of current stone array = l + 1
            for (var i = 0; i < n - l; i++) {
                dp[i] = Math.max((prefix[i + l] - prefix[i]) - dp[i + 1],
                        prefix[i + l - 1] - (i > 0 ? prefix[i - 1] : 0) - dp[i]      // sum(i, i + l - 1)
                );
            }
        }
        return dp[0];
    }

    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        memo = new Integer[n][n];
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        return dp(0, n - 1);
    }

    int getSum(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }

    int dp(int left, int right) {
        // only 1 stone, score = 0 -> difference = 0 as well
        if (left == right) {
            return 0;
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        int scoreRemoveLeftMost = getSum(left + 1, right);
        int scoreRemoveRightMost = getSum(left, right - 1);
        int ans = Math.max(
                scoreRemoveLeftMost - dp(left + 1, right),
                scoreRemoveRightMost - dp(left, right - 1)
        );
        memo[left][right] = ans;
        return memo[left][right];
    }
}