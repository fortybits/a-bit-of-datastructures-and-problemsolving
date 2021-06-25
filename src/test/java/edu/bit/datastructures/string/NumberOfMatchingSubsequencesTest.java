package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfMatchingSubsequencesTest {

    NumberOfMatchingSubsequences numberOfMatchingSubsequences = new NumberOfMatchingSubsequences();

    @Test
    void testNumMatchingSubsequence() {
        Assertions.assertEquals(3,
                numberOfMatchingSubsequences.numMatchingSubsequence("abcde",
                        new String[]{"a", "bb", "acd", "ace"}));
        Assertions.assertEquals(2,
                numberOfMatchingSubsequences.numMatchingSubsequence("dsahjpjauf",
                        new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }
}