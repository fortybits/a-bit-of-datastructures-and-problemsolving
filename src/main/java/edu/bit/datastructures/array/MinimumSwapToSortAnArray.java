package edu.bit.datastructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n distinct elements, find the minimum number of swaps required to sort the array.
 */
public class MinimumSwapToSortAnArray {

    public int minSwaps(int[] arr) {
        // Hashmap which stores the indexes of the input array
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueToIndexMap.put(arr[i], i);
        }

        int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(temp);
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            // This is checking whether the current element is at the right place or not
            if (arr[i] != temp[i]) {
                ans++;
                int init = arr[i];
                // If not, swap this element with the index of the element which should come here
                swap(arr, i, valueToIndexMap.get(temp[i]));
                // Important: update the indexes in the hashmap accordingly
                valueToIndexMap.put(init, valueToIndexMap.get(temp[i]));
                valueToIndexMap.put(temp[i], i);
            }
        }
        return ans;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}