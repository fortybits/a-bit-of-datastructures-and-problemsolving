package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestConsecutiveNumbersTest {

    LongestConsecutiveNumbers longestConsecutiveNumbers = new LongestConsecutiveNumbers();

    @Test
    void testLongestConsecutive() {
        Assertions.assertEquals(4,
                longestConsecutiveNumbers.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        Assertions.assertEquals(9,
                longestConsecutiveNumbers.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        Assertions.assertEquals(0,
                longestConsecutiveNumbers.longestConsecutive(new int[]{}));
    }
}