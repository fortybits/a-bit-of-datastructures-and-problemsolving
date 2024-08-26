package edu.bit.datastructures.search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * <p>
 * An integer a is closer to x than an integer b if:
 * <p>
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class KClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(arr, left, left + k)
                .boxed()
                .collect(Collectors.toList());
    }
}
