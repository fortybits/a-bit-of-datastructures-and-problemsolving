package edu.bit.datastructures.array;

import edu.bit.annotations.organisation.Swiggy;
import edu.bit.annotations.topics.Array;
import edu.bit.annotations.topics.PrefixSum;

/**
 * Given an Array of Positive and Negative Integers,
 * find out the Maximum sub-array Sum in that Array.
 */
@Swiggy
@Array
@PrefixSum
public class MaxSubArraySum {

    // -10^5 < arr[i] <= 10^5 and arr.length <= 3 lakh
    // (during interview) exponential way would be to find out all sub arrays and their sums and max out of it
    // arr[] = {2, 4, 5, -14 , 9, 1} ..output => 11
    //          2, 6, 11, -3, 9, 10   (as soon as I find negative number in prefixSumComputation
    // {2, 6, 11, 4  , 13, 14} => 14
    // find out maximum
    // if I get a negative value, everything ahead in prefix sum is start afresh for rest of sub array
    // {2, 4, -4, 5, -1, 9, 1} {2,6,2,7,6,15,16} => 16

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