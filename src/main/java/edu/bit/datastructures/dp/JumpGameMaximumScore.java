package edu.bit.datastructures.dp;

import java.util.LinkedList;

/**
 * You are given a 0-indexed integer array nums and an integer k.
 * <p>
 * You are initially standing at index 0. In one move, you can jump at most k steps forward without
 * going outside the boundaries of the array. That is, you can jump from
 * index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.
 * <p>
 * You want to reach the last index of the array (index n - 1).
 * Your score is the sum of all nums[j] for each index j you visited in the array.
 * <p>
 * Return the maximum score you can get.
 */
public class JumpGameMaximumScore {

    // the naive solution is exponential, but if we optimise it with memoization
    // we can reach to O(k*N) complexity with extra space O(N)
    public int maxResult(int[] nums, int k) {
        // hint: the maximum score to reach the end starting at index i
        int n = nums.length;
        int[] scores = new int[n];
        for (int i = 0; i < n - 1; i++) {
            scores[i] = Integer.MIN_VALUE;
        }
        scores[n - 1] = nums[n - 1];
        return solve(nums, scores, k, 0);
    }

    // recursive solver which finds max score to reach n-1 starting from ith index with k steps possible at a time
    int solve(int[] nums, int[] scores, int k, int i) {
        if (scores[i] != Integer.MIN_VALUE) {
            return scores[i];
        }
        // try jumps of all length and choose the one which maximises the score
        for (int j = 1; j <= k; j++) {
            if (i + j < nums.length) {
                scores[i] = Math.max(scores[i], nums[i] + solve(nums, scores, k, i + j));
            }
        }
        return scores[i];
    }

    public int maxResultOpt(int[] nums, int k) {
        int n = nums.length;
        int[] scores = new int[n];
        scores[0] = nums[0];

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);

        for (int i = 1; i < n; i++) {
            if (queue.getFirst() < i - k) {
                queue.removeFirst();
            }
            scores[i] = scores[queue.getFirst()] + nums[i];

            while (!queue.isEmpty() && scores[queue.getLast()] <= scores[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        return scores[n - 1];
    }
}