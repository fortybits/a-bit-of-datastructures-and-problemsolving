package edu.bit.datastructures.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestStringChainLengthTest {

    LongestStringChainLength longestStringChainLength = new LongestStringChainLength();

    @Test
    void testLongestStrChainLength() {
        Assertions.assertEquals(4,
                longestStringChainLength.longestStringChainLength(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        Assertions.assertEquals(5,
                longestStringChainLength.longestStringChainLength(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
        Assertions.assertEquals(1,
                longestStringChainLength.longestStringChainLength(new String[]{"abcd", "dbqca"}));
    }
}