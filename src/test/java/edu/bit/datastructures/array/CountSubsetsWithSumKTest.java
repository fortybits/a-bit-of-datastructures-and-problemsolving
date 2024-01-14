package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountSubsetsWithSumKTest {

    CountSubsetsWithSumK countSubsetsWithSumK = new CountSubsetsWithSumK();

    @Test
    void testFindSubArraySumToKCounts() {
        Assertions.assertEquals(3,
                countSubsetsWithSumK.findSubArraySumToKCounts(new int[]{10, 2, -2, -20, 10}, -10));
        Assertions.assertEquals(2,
                countSubsetsWithSumK.findSubArraySumToKCounts(new int[]{9, 4, 20, 3, 10, 5}, 33));

        Assertions.assertEquals(3,
                countSubsetsWithSumK.findSubsetCounts(new int[]{1, 2, 3, 4, 5}, 0, 9, 5));
        Assertions.assertEquals(4,
                countSubsetsWithSumK.findSubsetCounts(new int[]{9, 4, 20, 3, 10, 5}, 0, 33, 6));
    }
}