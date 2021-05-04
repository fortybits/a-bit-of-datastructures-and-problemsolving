package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubArraySumKTest {

    LongestSubArraySumK longestSubArraySumK = new LongestSubArraySumK();

    @Test
    void testLongestSubArraySumWithValidInput() {
        Assertions.assertEquals(4,
                longestSubArraySumK.longestSubArraySum(new int[]{10, 5, 2, 7, 1, 9}, 6, 15));

        Assertions.assertEquals(5,
                longestSubArraySumK.longestSubArraySum(new int[]{-5, 8, -14, 2, 4, 12}, 6, -5));

        Assertions.assertEquals(11,
                longestSubArraySumK.longestSubArraySum(new int[]{1, 3, 4, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}, 15, 10));
    }

    @Test
    void testLongestSubArraySumWithInvalidInput() {
        Assertions.assertEquals(0,
                longestSubArraySumK.longestSubArraySum(new int[]{10, 5, 2, 7, 1, 9}, 6, 6));
    }

}