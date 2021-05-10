package edu.bit.datastructures.array;

/**
 * We have two integer sequences nums1 and nums2 of the same non-zero length.
 * <p>
 * We are allowed to swap elements nums1[i] and nums2[i].
 * Note that both elements are in the same index position in their respective sequences.
 * <p>
 * At the end of some number of swaps, nums1 and nums2 are both strictly increasing.
 * (An array A is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 * <p>
 * Given nums1 and nums2, return the minimum number of swaps to make both sequences strictly increasing.
 * It is guaranteed that the given input always makes it possible.
 */
public class MinimumSwapForIncreasingNumbers {

    /**
     * A[i - 1] < A[i] && B[i - 1] < B[i].
     * In this case, if we want to keep A and B increasing before the index i, can only have two choices.
     * -> 1.1 don't swap at (i-1) and don't swap at i, we can get not_swap[i] = not_swap[i-1]
     * -> 1.2 swap at (i-1) and swap at i, we can get swap[i] = swap[i-1]+1
     * if swap at (i-1) and do not swap at i, we can not guarantee A and B increasing.
     * <p>
     * A[i-1] < B[i] && B[i-1] < A[i]
     * In this case, if we want to keep A and B increasing before the index i, can only have two choices.
     * -> 2.1 swap at (i-1) and do not swap at i, we can get notswap[i] = Math.min(swap[i-1], notswap[i] )
     * -> 2.2 do not swap at (i-1) and swap at i, we can get swap[i]=Math.min(notswap[i-1]+1, swap[i])
     * <p>
     * swap[i]: min swaps to make A[0: i] and B[0:i] increasing if we swap A[i] and B[i]
     * withoutSwap[i]: min swaps to make A[0: i] and B[0:i] increasing if we do not swap A[i] and B[i]
     */
    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[N];
        int[] withoutSwap = new int[N];
        swap[0] = 1;
        for (int i = 1; i < N; ++i) {
            withoutSwap[i] = swap[i] = N;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                swap[i] = swap[i - 1] + 1;
                withoutSwap[i] = withoutSwap[i - 1];
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                swap[i] = Math.min(swap[i], withoutSwap[i - 1] + 1);
                withoutSwap[i] = Math.min(withoutSwap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[N - 1], withoutSwap[N - 1]);
    }


    public int minSwapOptimisedSpace(int[] A, int[] B) {
        int withSwap = 1;
        int withoutSwap = 0;
        for (int i = 1; i < A.length; ++i) {
            int tempWithoutSwap = A.length;
            int tempWithSwap = A.length;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                tempWithSwap = withSwap + 1;
                tempWithoutSwap = withoutSwap;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                tempWithSwap = Math.min(tempWithSwap, withoutSwap + 1);
                tempWithoutSwap = Math.min(tempWithoutSwap, withSwap);
            }
            // make them values for i-1
            withSwap = tempWithSwap;
            withoutSwap = tempWithoutSwap;
        }
        return Math.min(withSwap, withoutSwap);
    }
}