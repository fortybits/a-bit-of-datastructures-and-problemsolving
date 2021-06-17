package edu.bit.datastructures.array;

/**
 * We are given an array nums of positive integers, and two positive integers left and right (left <= right).
 * <p>
 * Return the number of (contiguous, non-empty) subarrays such that the value of the
 * maximum array element in that subarray is at least left and at most right.
 */
public class SubArrayCountWithMaximumBound {

    public int numSubArrayBoundedMax(int[] nums, int left, int right) {
        int j = 0;
        int count = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                res += i - j + 1;
                count = i - j + 1;
            } else if (nums[i] < left) {
                res += count;
            } else {
                j = i + 1;
                count = 0;
            }
        }
        return res;
    }
}