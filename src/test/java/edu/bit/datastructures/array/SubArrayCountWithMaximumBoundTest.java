package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubArrayCountWithMaximumBoundTest {

    SubArrayCountWithMaximumBound subArrayCountWithMaximumBound = new SubArrayCountWithMaximumBound();

    @Test
    void testNumSubArrayBoundedMax() {
        Assertions.assertEquals(3,
                subArrayCountWithMaximumBound.numSubArrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }
}