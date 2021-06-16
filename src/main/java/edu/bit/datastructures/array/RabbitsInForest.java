package edu.bit.datastructures.array;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * There is a forest with an unknown number of rabbits.
 * We asked n rabbits "How many rabbits have the same color as you?"
 * and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
 * <p>
 * Given the array answers, return the minimum number of rabbits that could be in the forest
 */
public class RabbitsInForest {

    // [1,1,2]
    // Blue(2), Black(2), Red(3) => 7
    // Blue(2), Blue(2), Red(3) => 5
    // find out unique inputs and sum them to find out the minimum possible counts
    // [1, 1, 2, 4, 6, 3, 2, 1]

    // [2, 2, 3, 5, 7, 4, 3, 2]
    // [2,2, 2,2, 2,2, 2,2, 2] 2*5 => 10
    // [3,3,3,3] => [4,4,4,4] 4*1 = 4
    // [2,2, 2,2, 2,2, 2,2, 2,4,4,4,4,4]
    // 2 => 9 (5) and 4 => 5 (2)

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> frequencyOfCounts = Arrays.stream(answers).boxed()
                .collect(Collectors.toMap(i -> i + 1, i -> 1, Integer::sum));

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