package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestIncreasingSubsequenceTest {

    LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();

    @Test
    void lengthOfLongestIncreasingSubsequence() {
        Assertions.assertEquals(4,
                longestIncreasingSubsequence.lengthOfLongestIncreasingSubsequenceOptimised(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Assertions.assertEquals(4,
                longestIncreasingSubsequence.lengthOfLongestIncreasingSubsequenceOptimised(new int[]{0, 1, 0, 3, 2, 3}));
        Assertions.assertEquals(1,
                longestIncreasingSubsequence.lengthOfLongestIncreasingSubsequenceOptimised(new int[]{7, 7, 7, 7}));
        Assertions.assertEquals(5,
                longestIncreasingSubsequence.lengthOfLongestIncreasingSubsequenceOptimised(new int[]{2, 6, 3, 4, 1, 2, 9, 5, 8}));
    }
}