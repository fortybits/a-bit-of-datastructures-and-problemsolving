package edu.bit.datastructures.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    // one approach is to follow recursion and tail at 0,1
    // this would mean O(2^n) runtime with O(N) space
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    // to optimise we can simply memoize and reduce the runtime complexity to  O(N)
    public int climbStairsMemo(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));
        }
        return memo.get(n);
        // https://stackoverflow.com/questions/54824656/since-java-9-hashmap-computeifabsent-throws-concurrentmodificationexception-on
        // return memo.computeIfAbsent(n, curr -> climbStairs(curr - 1, memo) + climbStairs(curr - 2, memo));
        // java.util.ConcurrentModificationException
        //  at line 1229, java.base/java.util.HashMap.computeIfAbsent
        //  at line 11, Solution.climbStairs
    }

    // transforming the memoization to a bottom up approach we end up using the same space and time
    public int climbStairsTabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    // finally we can simplify this further to reduce the space occupied
    int climbStairsSpaceOpt(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}