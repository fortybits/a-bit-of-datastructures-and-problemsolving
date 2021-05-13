package edu.bit.datastructures.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSumOrSmaller {

    public  Set<List<Integer>> findTriplets(int[] arr, int sum) {
        // Sort input array
        Arrays.sort(arr);
        int n = arr.length;
        Set<List<Integer>> result = new HashSet<>();
        // Every iteration of loop counts triplet with
        // first element as arr[i].
        for (int i = 0; i < n - 2; i++) {

            // Initialize other two elements as corner
            // elements of subarray arr[j+1..k]
            int j = i + 1;
            int k = n - 1;

            // Use Meet in the Middle concept
            while (j < k) {

                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                if (arr[i] + arr[j] + arr[k] >= sum) {
                    k--;
                } else {       // Else move left corner
                    // This is important. For current i and j,
                    // there are total k-j third elements.
                    for (int x = j + 1; x <= k; x++) {
                        result.add(List.of(arr[i], arr[j], arr[x]));
                    }
                    j++;
                }
            }
        }
        return result;
    }
}