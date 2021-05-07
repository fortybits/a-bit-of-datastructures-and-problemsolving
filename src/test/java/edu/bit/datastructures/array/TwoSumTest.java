package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    TwoSum twoSum = new TwoSum();

    @Test
    void twoSum() {
        Assertions.assertArrayEquals(new int[]{0, 1},
                twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));

        Assertions.assertArrayEquals(new int[]{1, 2},
                twoSum.twoSum(new int[]{3, 2, 4}, 6));

        Assertions.assertArrayEquals(new int[]{0, 1},
                twoSum.twoSum(new int[]{3, 3}, 6));
    }
}