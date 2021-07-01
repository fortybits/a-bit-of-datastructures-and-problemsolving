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

        Assertions.assertEquals(11,
                maxSubArraySum.maximumSubArraySum(new int[]{2, 4, 5, -14, 9, 1}));

        Assertions.assertEquals(6,
                maxSubArraySum.maximumSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        Assertions.assertEquals(5,
                maxSubArraySum.maximumSubArraySum(new int[]{5}));

        Assertions.assertEquals(23,
                maxSubArraySum.maximumSubArraySum(new int[]{5, 4, -1, 7, 8}));
    }
}