package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MakeSumDivisibleByPTest {

    MakeSumDivisibleByP makeSumDivisibleByP = new MakeSumDivisibleByP();

    @Test
    void testMinSubArray() {
        Assertions.assertEquals(1,
                makeSumDivisibleByP.minSubArray(new int[]{3, 1, 4, 2}, 6));
        Assertions.assertEquals(2,
                makeSumDivisibleByP.minSubArray(new int[]{6, 3, 5, 2}, 9));
        Assertions.assertEquals(0,
                makeSumDivisibleByP.minSubArray(new int[]{1, 2, 3}, 3));
        Assertions.assertEquals(-1,
                makeSumDivisibleByP.minSubArray(new int[]{1, 2, 8}, 7));
    }
}