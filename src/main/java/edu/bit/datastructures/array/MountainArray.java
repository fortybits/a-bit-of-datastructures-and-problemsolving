package edu.bit.datastructures.array;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */
public class MountainArray {

    public boolean validMountainArray(int[] arr) {
        int upperBound = arr.length - 1;
        int lowerBound = 0;

        int i = lowerBound;
        while (i < upperBound && arr[i] < arr[i + 1]) i++;

        int j = upperBound;
        while (j > lowerBound && arr[j - 1] > arr[j]) j--;

        return i > lowerBound && i == j && j < upperBound;
    }
}
