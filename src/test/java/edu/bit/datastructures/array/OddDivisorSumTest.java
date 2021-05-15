package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OddDivisorSumTest {

    OddDivisorSum oddDivisorSum = new OddDivisorSum();

    @Test
    void testOddDivisorCount() {
        Assertions.assertEquals(38,
                oddDivisorSum.countTotalOddDivisors(new int[]{6, 11, 15, 23, 21, 9, 56}));
    }
}