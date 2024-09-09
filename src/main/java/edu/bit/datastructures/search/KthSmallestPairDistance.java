package edu.bit.datastructures.search;

import java.util.Arrays;

/**
 * The distance of a pair of integers a and b is defined as the absolute difference between a and b.
 * <p>
 * Given an integer array nums and an integer k, return the kth smallest distance among
 * all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
 * <p>
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 */
public class KthSmallestPairDistance {

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); // nlogn

        // Minimum absolute difference
        int low = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++)
            low = Math.min(low, nums[i + 1] - nums[i]);

        // Maximum absolute difference
        int high = nums[n - 1] - nums[0];

        // Do binary search for k-th absolute difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    // Returns number of pairs with absolute difference less than or equal to mid.
    private int countPairs(int[] nums, int mid) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += upperBound(nums, i, n - 1, nums[i] + mid) - i - 1;
        }
        return res;
    }

    // Returns index of first index of element which is greater than key
    private int upperBound(int[] nums, int low, int high, int key) {
        if (nums[high] <= key) return high + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key >= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}