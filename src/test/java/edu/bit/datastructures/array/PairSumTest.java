package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class PairSumTest {

    PairSum pairSum = new PairSum();

    @Test
    void maximalSubsetPairNotDivisibleByK() {
        Assertions.assertEquals(List.of(Map.entry(17, 7)),
                pairSum.findPairsWithSum(new int[]{7, 5, 17, 20, 25, 28, 34, 3, 26}, 24));

        Assertions.assertEquals(List.of(Map.entry(5, 5), Map.entry(3, 7)),
                pairSum.findPairsWithSum(new int[]{2, 5, 5, 2, 7, 1, 4, 3, 2}, 10));

        Assertions.assertEquals(List.of(Map.entry(5, 5), Map.entry(3, 7)),
                pairSum.findUniquePairsWithSum(new int[]{2, 5, 5, 2, 7, 1, 4, 3, 2}, 10));

        Assertions.assertEquals(List.of(Map.entry(2, 5), Map.entry(5, 2), Map.entry(4, 3)),
                pairSum.findUniquePairsWithSum(new int[]{2, 5, 5, 2, 7, 1, 4, 3, 2}, 7));
    }
}