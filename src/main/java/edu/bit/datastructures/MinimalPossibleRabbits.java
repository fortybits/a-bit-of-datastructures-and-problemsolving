package edu.bit.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * In a forest, there are rabbits of different colors, we speak to a subset of rabbits.
 * We wouldn't talk to duplicates and each rabbit tells me a number which indicates
 * number of other rabbits with same color.
 * We need to find out the minimum numbers of rabbits present in the forest
 */
public class MinimalPossibleRabbits {

    public int minimalRabbits(int[] answers) {
        int n = answers.length;

        // this was an extra space that was consumed to save off the computation of +1
        // while creating frequency map and adding to the total
        int[] updated = new int[n];
        for (int i = 0; i < n; i++) {
            updated[i] = answers[i] + 1;
        }

        Map<Integer, Integer> frequencyOfCounts = new HashMap<>();
        for (int i : updated) {
            frequencyOfCounts.merge(i, 1, Integer::sum);
        }

        int minimumRabbits = 0; //default
        for (Map.Entry<Integer, Integer> entry : frequencyOfCounts.entrySet()) {
            int tempCount = entry.getKey();
            int totalInputs = entry.getValue();
            int parts = totalInputs / tempCount;
            if (totalInputs % tempCount != 0) {
                parts = parts + 1;
            }
            minimumRabbits = minimumRabbits + (parts * tempCount);
        }
        return minimumRabbits;
    }
}