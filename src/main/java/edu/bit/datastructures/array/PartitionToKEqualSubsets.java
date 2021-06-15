package edu.bit.datastructures.array;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer k, return true if it is possible to divide this
 * array into k non-empty subsets whose sums are all equal.
 */
public class PartitionToKEqualSubsets {

    // this is inn general a problem where we need to partition a set into K equal sum subsets
    public boolean partitionIntoEqualSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        return Arrays.stream(nums).noneMatch(num -> num > target) &&
                dfs(new boolean[nums.length], nums, 0, target, 0, k);
    }

    private boolean dfs(boolean[] visited, int[] nums, int start, int target, int sum, int k) {
        if (k == 1) {
            return true;
        }
        if (target == sum) {
            return dfs(visited, nums, 0, target, 0, k - 1);
        }
        if (sum > target) {
            return false;
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (dfs(visited, nums, i + 1, target, sum + nums[i], k)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}