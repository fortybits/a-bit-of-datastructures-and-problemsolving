package edu.bit.datastructures.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums and an integer target.
 * <p>
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums
 * and then concatenate all the integers.
 * <p>
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 */
public class TargetSum {
    int result = 0; // count of ways

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        dfs(nums, target, 0, 0);
        return result;
    }

    public void dfs(int[] nums, int target, int index, int currSum) {
        if (index == nums.length) {
            if (currSum == target) {
                result++;
            }
            return;
        }
        dfs(nums, target, index + 1, currSum + nums[index]);
        dfs(nums, target, index + 1, currSum - nums[index]);
    }

    private Map<String, Integer> memo;

    public int findTargetSumWaysMemoize(int[] nums, int S) {
        int index = nums.length - 1;
        int currSum = 0;
        memo = new HashMap<>();
        return dp(nums, S, index, currSum);
    }

    private int dp(int[] nums, int target, int index, int currSum) {
        String key = index + "," + currSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (index < 0 && currSum == target) {
            return 1;
        }
        if (index < 0) {
            return 0;
        }

        int positive = dp(nums, target, index - 1, currSum + nums[index]);
        int negative = dp(nums, target, index - 1, currSum - nums[index]);

        memo.put(key, positive + negative);
        return memo.get(key);
    }
}