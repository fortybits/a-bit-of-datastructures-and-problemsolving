package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubArraysSumDivisibleByKTest {

    SubArraysSumDivisibleByK subArraysSumDivisibleByK = new SubArraysSumDivisibleByK();

    @Test
    void testSubArraysDivByK() {
        Assertions.assertEquals(7,
                subArraysSumDivisibleByK.countSubArraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}