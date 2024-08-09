package edu.bit.datastructures.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums and an integer target, return all pairs such that they add up to target.
 * You can return the answer in any order.
 */
public class PairSum {

    // Time Complexity: O(n) Auxiliary Space: O(n) where n is size of array
    public List<Map.Entry<Integer, Integer>> findPairsWithSum(int[] arr, int sum) {
        List<Map.Entry<Integer, Integer>> pairsWithSum = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int j : arr) {
            int temp = sum - j;
            // checking for condition
            if (temp >= 0 && seen.contains(temp)) {
                pairsWithSum.add(Map.entry(j, temp));
            }
            seen.add(j);
        }
        return pairsWithSum;
    }

    public List<Map.Entry<Integer, Integer>> findUniquePairsWithSum(int[] arr, int sum) {
        Map<Integer, Long> frequencyMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Set<Integer> uniqueNumbers = frequencyMap.keySet();
        List<Map.Entry<Integer, Integer>> result = new ArrayList<>();

        for (Integer uniqueNumber : uniqueNumbers) {
            int otherNumber = sum - uniqueNumber;
            if (frequencyMap.containsKey(otherNumber) && frequencyMap.get(otherNumber) != 0) {
                long pairsWithSameCombination = Math.min(frequencyMap.get(uniqueNumber), frequencyMap.get(otherNumber));
                if (uniqueNumber == otherNumber && pairsWithSameCombination == 1) continue;
                else {
                    for (int i = 0; i < pairsWithSameCombination; i++) {
                        result.add(Map.entry(uniqueNumber, otherNumber));
                        frequencyMap.put(uniqueNumber, frequencyMap.get(uniqueNumber) - 1);
                        frequencyMap.put(otherNumber, frequencyMap.get(uniqueNumber) - 1);
                    }
                }
            }
        }
        return result;
    }
}
