package edu.bit.problemsolving.competitive.leet.weekly.april;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The frequency of an element is the number of times it occurs in an array.
 * You are given an integer array nums and an integer k.
 * In one operation, you can choose an index of nums and increment the element at that index by 1.
 * Return the maximum possible frequency of an element after performing at most k operations.
 */
public class FrequencyOfMostFrequentIntegerPossible {

    public static void main(String[] args) {
        FrequencyOfMostFrequentIntegerPossible frequency = new FrequencyOfMostFrequentIntegerPossible();
        System.out.println(frequency.maxFrequency(new int[]{1, 4, 8, 13}, 5)); // 2
        System.out.println(frequency.maxFrequency(new int[]{3, 9, 6}, 2)); // 1
        System.out.println(frequency.maxFrequency(new int[]{1, 2, 4}, 5)); // 3
        System.out.println(frequency.maxFrequency(new int[]{1, 2, 4}, 1)); // 2
    }

    // todo: complete this
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Long> frequency = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
        return 0;
    }

    static boolean possible(int[] arr, int N, int mid, int K) {
        int add = 0;

        for (int i = N / 2 - (N + 1) % 2; i < N; ++i) {
            if (mid - arr[i] > 0) {
                add += (mid - arr[i]);
                if (add > K)
                    return false;
            }
        }
        return add <= K;
    }


    static int findMaxMedian(int[] arr, int N, int K) {

        // Lowest possible median
        int low = 1;
        int mx = 0;

        for (int i = 0; i < N; ++i) {
            mx = Math.max(mx, arr[i]);
        }

        int high = K + mx;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (possible(arr, N, mid, K)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (N % 2 == 0) {
            if (low - 1 < arr[N / 2]) {
                return (arr[N / 2] + low - 1) / 2;
            }
        }
        // Return the max possible ans
        return low - 1;
    }
}