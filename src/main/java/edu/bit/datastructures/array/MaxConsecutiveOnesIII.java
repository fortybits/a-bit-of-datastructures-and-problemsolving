package edu.bit.datastructures.array;

/**
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 */
public class MaxConsecutiveOnesIII {

    // identify the longest consecutive ones, when flipping each 0 restricting unless k using sliding window
    public int longestOnes(int[] nums, int k) {
        // For each A[j], try to find the longest subarray.
        // If A[i] ~ A[j] has zeros <= K, we continue to increment j.
        // If A[i] ~ A[j] has zeros > K, we increment i (as well as j).
        int i = 0, j;
        for (j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) {
                k--;
            }
            if (k < 0 && nums[i++] == 0) {
                k++;
            }
        }
        return j - i;
    }
}