package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubSetWithNoPairSumDivisionTest {

    SubSetWithNoPairSumDivision subSetWithNoPairSumDivision = new SubSetWithNoPairSumDivision();

    @Test
    void maximalSubsetPairNotDivisibleByK() {
        Assertions.assertEquals(5, subSetWithNoPairSumDivision
                .maximalSubsetPairNotDivisibleByK(new int[]{7, 5, 17, 20, 25, 28, 34, 3, 26}, 4));
    }
}