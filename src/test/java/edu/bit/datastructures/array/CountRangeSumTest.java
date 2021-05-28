package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountRangeSumTest {

    CountRangeSum countRangeSum = new CountRangeSum();

    @Test
    void countRangeSum() {
        Assertions.assertEquals(1,
                countRangeSum.countRangeSumNaive(new int[]{0, -3, -4, -2, 5, -6}, 1, 4));
        Assertions.assertEquals(1,
                countRangeSum.countRangeSumDivideAndConquer(new int[]{0, -3, -4, -2, 5, -6}, 1, 4));
    }
}