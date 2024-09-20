package org.salesforce;

import java.util.List;

/**
 * You are given an array, you can swap adjacent elements only.
 * And one element can't be swapped twice. Meaning if we have swapped 0 1 then we can't swap 1 2.
 * So in this way what will be the maximum value of sigma(a[i] * (i + 1)) for each i from 0 to len.
 */
public class MaximumStrengthSum {

    // input [1,9,7,3,2]
    public static long getMaximumStrength(List<Integer> arr) {
        int n = arr.size();
        long totalStrength = 0;

        // Calculate initial strength based on the given formula
        for (int i = 0; i < n; i++) {
            totalStrength += (long) arr.get(i) * (i + 1);
        }

        long maxStrength = Long.MIN_VALUE;
        long swappedStrength = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                swappedStrength = totalStrength + (arr.get(i + 1) - arr.get(i));
                maxStrength = Math.max(maxStrength, swappedStrength);
            }
        }
        return maxStrength;
    }

    // Helper function to swap elements in the list
    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }


    class SwapStrength {
        long leftSwap;
        long rightSwap;
    }
}