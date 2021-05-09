package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreatestCommonDivisorTest {

    GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();

    @Test
    void testFindGCD() {
        Assertions.assertEquals(1,
                greatestCommonDivisor.findGCD(new int[]{1, 2, 3}));
        Assertions.assertEquals(2,
                greatestCommonDivisor.findGCD(new int[]{2, 4, 6, 8}));
        Assertions.assertEquals(1,
                greatestCommonDivisor.findGCD(new int[]{2, 5, 7, 19}));
    }
}