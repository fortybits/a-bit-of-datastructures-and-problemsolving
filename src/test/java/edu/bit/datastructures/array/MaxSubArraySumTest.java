package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSubArraySumTest {

    MaxSubArraySum maxSubArraySum = new MaxSubArraySum();

    @Test
    void testMaximumSumSubArray() {
        Assertions.assertEquals(7,
                maxSubArraySum.maximumSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}, 8));

        Assertions.assertEquals(7,
                maxSubArraySum.maximumSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));

        Assertions.assertEquals(-1,
                maxSubArraySum.maximumSubArraySum(new int[]{-2, -3, -44, -1, -2, -5, -10}));
    }
}