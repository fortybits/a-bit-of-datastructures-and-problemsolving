package edu.bit.datastructures.sorting;

/**
 * We have an array 𝐴 with 𝑛 elements. Rev(𝑖,𝑗) for 1≤𝑖<𝑗≤𝑛 reverses subarray 𝐴[𝑖…𝑗] , i.e., swaps 𝐴[𝑗−𝑘] and 𝐴[𝑖+𝑘] for all 0≤𝑘≤𝑗−𝑖.
 * <p>
 * How many times must we use Rev(𝑖,𝑗) to sort 𝐴 ?
 * <p>
 * Answer is: O(𝑛)!
 * <p>
 * How can I sort 𝐴, using Rev(𝑖,𝑗) in O(𝑛) times?
 */
public class SortArrayUsingReverse {

    int[] nums;

    public SortArrayUsingReverse(int[] nums) {
        this.nums = nums;
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            sortFrom(i, nums);
        }
    }


    // Sorting can be achieved using the pre-built function of reverse in a similar way as selection sorting does
    public static void sortFrom(int i, int[] nums) {
        int m = nums[i]; // Initial minimum value
        int mi = i;   // Index of the minimum value
        // Loop to find the smallest element in the remaining array
        for (int j = i; j < nums.length; j++) {
            if (nums[j] <= m) {
                mi = j;
                m = nums[mi];
            }
        }

        // Reverse the elements between i and mi
        reverse(i, mi, nums);
    }

    // Helper method to reverse elements between two indices
    public static void reverse(int start, int end, int[] A) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
}
