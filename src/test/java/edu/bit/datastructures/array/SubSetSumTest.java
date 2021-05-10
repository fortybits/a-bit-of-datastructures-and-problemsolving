package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubSetSumTest {

    SubSetSum subSetSum = new SubSetSum();

    @Test
    void testIsSubsetSum() {
        Assertions.assertTrue(subSetSum.isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 9));
        Assertions.assertFalse(subSetSum.isSubsetSum(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }

    @Test
    void testIsSubsetSumSpaceOptimised() {
        Assertions.assertTrue(subSetSum.isSubsetSumSpaceOptimised(new int[]{3, 34, 4, 12, 5, 2}, 9));
        Assertions.assertFalse(subSetSum.isSubsetSumSpaceOptimised(new int[]{3, 34, 4, 12, 5, 2}, 30));
    }
}