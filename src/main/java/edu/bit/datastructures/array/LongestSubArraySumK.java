package edu.bit.datastructures.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array arr[] of size n containing integers.
 * The problem is to find the length of the longest sub-array having sum equal to the given value k.
 * -10^5 < arr[i] < 10^5 and same for K
 */
public class LongestSubArraySumK {

    // Naive approach is to iterate through each element consider the first element (i ... N-1)
    // iterate trough the rest of integers (from i to N-1) and find the length of sub array with same sum as target
    // this would result in O(N*N) complexity
    public int naiveLongestSubArraySum(int[] A, int Y) {
        int maxSubArrayLength = 0;
        for (int i = 0; i < A.length; i++) {
            int currentSum = 0;
            int currentSubArrayLength = 0;
            for (int j = i; j < A.length; j++) {
                currentSum = currentSum + A[j];
                currentSubArrayLength++;
                if (currentSum == Y && currentSubArrayLength > maxSubArrayLength) {
                    maxSubArrayLength = currentSubArrayLength;
                }
            }
        }
        return maxSubArrayLength;
    }

    // reference https://www.geeksforgeeks.org/longest-sub-array-sum-k/
    public int longestSubArraySum(int[] arr, int n, int k) {
        // Map to store (sum, index) tuples
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;

        // traverse the given array
        for (int i = 0; i < n; i++) {

            // accumulate sum
            sum += arr[i];

            // when sub array starts from index '0'
            if (sum == k) {
                maxLen = i + 1;
            }

            // make an entry for 'sum' if it is not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map' or not
            if (map.containsKey(sum - k)) {
                // update maxLength
                if (maxLen < (i - map.get(sum - k))) {
                    maxLen = i - map.get(sum - k);
                }
            }
        }
        return maxLen;
    }
}