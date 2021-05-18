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
    }
}