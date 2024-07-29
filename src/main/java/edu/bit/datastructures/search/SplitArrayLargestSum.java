package edu.bit.datastructures.search;

/**
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that
 * the largest sum of any subarray is minimized.
 * <p>
 * Return the minimized largest sum of the split.
 * <p>
 * A subarray is a contiguous part of the array.
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max); // if to be distributed amongst N person
            sum += num; // if to be distributed to 1 person
        }
        if (m == 1) return (int) sum;
        if (m == nums.length) return max;

        //binary search
        long l = max;
        long r = sum;
        while (l <= r) {
            long mid = (l + r) / 2; // trying to find the balance
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    // if we are able to distribute the nums in m places which are all with values lesser that the target
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}