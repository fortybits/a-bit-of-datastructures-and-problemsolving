package edu.bit.datastructures.array;

/**
 * Given an Array of Positive and Negative Integers,
 * find out the Maximum sub-array Sum in that Array.
 */
public class MaxSubArraySum {

    // Sol:: naive approach here would take a O(N*N) time to execute

    // a possible optimisation could be made to reduce the complexity
    // to O(N) with O(N) space for prefix sum computation
    public int maximumSubArraySum(int[] arr, int n) {
        // Initialize minimum prefix sum to 0.
        int minPrefixSum = 0;

        // Initialize maximum sub-array sum so far to -infinity.
        int res = Integer.MIN_VALUE;

        // Initialize and compute the prefix sum array.
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // loop through the array
        // keep track of minimum prefix sum so far and maximum sub-array sum.
        for (int i = 0; i < n; i++) {
            res = Math.max(res, prefixSum[i] - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum[i]);
        }

        return res;
    }

    // further if we could just keep a track of the positive sum segments with pointers,
    // we could save the space as well to O(1)
    public int maximumSubArraySum(int[] a) {
        int size = a.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        int length = 1;
        for (int i = 0; i < size; i++) {
            maxEndingHere = maxEndingHere + a[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                length++;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                length = 1;
            }
        }
        System.out.println(length);
        return maxSoFar;
    }
}