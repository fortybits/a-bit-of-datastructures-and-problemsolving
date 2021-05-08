package edu.bit.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two sorted arrays arr1[] of size N and arr2[] of size M.
 * Each array is sorted in non-decreasing order.
 * Merge the two arrays into one sorted array in non-decreasing order without using any extra space.
 */
public class MergeArrays {

    public void mergeWithoutExtraSpace(int[] arr1, int[] arr2, int n, int m) {
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < m) {
            if (arr1[i] >= arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // the method works with an extra space O(M+N) and has runtime complexity of O(M+N) as well
    public List<Integer> mergeListsToSortedResult(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>(firstList.size() + secondList.size());
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < firstList.size() && j < secondList.size()) {
            if (firstList.get(i) <= secondList.get(j)) {
                result.add(k, firstList.get(i));
                i++;
            } else {
                result.add(k, secondList.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of nodes if any */
        while (i < firstList.size()) {
            result.add(k, firstList.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < secondList.size()) {
            result.add(k, secondList.get(j));
            j++;
            k++;
        }
        return result;
    }
}