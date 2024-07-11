package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsomorphicStringsTest {


    IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

    @Test
    void testIsomorphicStrings() {
        Assertions.assertTrue(isomorphicStrings.isIsomorphic("egg", "add"));
        Assertions.assertFalse(isomorphicStrings.isIsomorphic("foo", "bar"));
        Assertions.assertTrue(isomorphicStrings.isIsomorphic("paper", "title"));
        Assertions.assertFalse(isomorphicStrings.isIsomorphic("badc", "baba"));
    }
}