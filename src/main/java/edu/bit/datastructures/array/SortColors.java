package edu.bit.datastructures.array;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
 * same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {

    /* Swap values at index i and j. */
    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    int[] sortColors(int[] input, int n) {
        int second = n - 1, zero = 0;
        for (int i = 0; i <= second; i++) {
            while (input[i] == 2 && i < second) swap(input, i, second--);
            while (input[i] == 0 && i > zero) swap(input, i, zero++);
        }
        return input;
    }
}