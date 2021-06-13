package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PalindromePairsTest {

    PalindromePairs palindromePairs = new PalindromePairs();

    @Test
    void testPalindromePairs() {
        Assertions.assertEquals(List.of(List.of(1, 0), List.of(0, 1), List.of(3, 2), List.of(2, 4)),
                palindromePairs.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        Assertions.assertEquals(List.of(List.of(1, 0), List.of(0, 1)),
                palindromePairs.palindromePairs(new String[]{"bat", "tab", "cat"}));
        Assertions.assertEquals(List.of(List.of(0, 1), List.of(1, 0)),
                palindromePairs.palindromePairs(new String[]{"a", ""}));
        Assertions.assertEquals(List.of(List.of(0, 1)),
                palindromePairs.palindromePairs(new String[]{"bat", "aaatab", "cat"}));
    }
}