package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InterleavingStringsTest {

    InterleavingStrings interleavingStrings = new InterleavingStrings();

    @Test
    void testIsInterleave() {
        Assertions.assertTrue(interleavingStrings.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        Assertions.assertTrue(interleavingStrings.isInterleave("", "", ""));
        Assertions.assertTrue(interleavingStrings.isInterleave("", "dbbca", "dbbca"));
        Assertions.assertFalse(interleavingStrings.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    void testIsInterleaveViaDynamicProgramming() {
        Assertions.assertTrue(interleavingStrings.isInterleaveDP("aabcc", "dbbca", "aadbbcbcac"));
        Assertions.assertTrue(interleavingStrings.isInterleaveDP("", "", ""));
        Assertions.assertTrue(interleavingStrings.isInterleaveDP("", "dbbca", "dbbca"));
        Assertions.assertFalse(interleavingStrings.isInterleaveDP("aabcc", "dbbca", "aadbbbaccc"));
    }
}