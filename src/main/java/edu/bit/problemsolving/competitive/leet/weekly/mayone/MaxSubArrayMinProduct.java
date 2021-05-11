package edu.bit.problemsolving.competitive.leet.weekly.mayone;

/**
 * The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.
 * <p>
 * For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20.
 * Given an array of integers nums, return the maximum min-product of any non-empty sub-array of nums.
 * Since the answer may be large, return it modulo 109 + 7.
 * <p>
 * Note that the min-product should be maximized before performing the modulo operation.
 * Testcases are generated such that the maximum min-product without modulo will fit in a 64-bit signed integer.
 * <p>
 * A sub-array is a contiguous part of an array.
 */
public class MaxSubArrayMinProduct {

    public int maxSumMinProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0] * nums[0];
        }
        long maxVal = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] arr = new int[j - i + 1];
                for (int k = i, l = 0; k <= j; k++, l++) {
                    arr[l] = nums[k];
                }
                long mP = minProductOfSubArray(arr);
                if (mP > maxVal) {
                    maxVal = mP;
                }
            }
        }
        return (int) maxVal;
    }

    private long minProductOfSubArray(int[] subArray) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i : subArray) {
            sum += i;
            if (min > i) {
                min = i;
            }
        }
        return (long) sum * min;
    }
}