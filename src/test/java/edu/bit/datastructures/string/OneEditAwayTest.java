package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OneEditAwayTest {

    OneEditAway oneEditAway = new OneEditAway();

    @Test
    void testStringsOneAway() {
        Assertions.assertTrue(oneEditAway.oneAway("pale", "pole"));
        Assertions.assertTrue(oneEditAway.oneAway("hole", "pole"));
    }

    @Test
    void testStringsWithMoreDifferences() {
        Assertions.assertFalse(oneEditAway.oneAway("pale", "bake"));
    }

    @Test
    void testSameStrings() {
        Assertions.assertFalse(oneEditAway.oneAway("cute", "cute"));
        Assertions.assertFalse(oneEditAway.oneAway("", ""));
    }

    @Test
    void testCharacterInsertionAndDeletion() {
        Assertions.assertTrue(oneEditAway.oneAway("pale", "pal"));
        Assertions.assertTrue(oneEditAway.oneAway("pale", "pales"));
        Assertions.assertTrue(oneEditAway.oneAway("drink", "drin"));
        Assertions.assertTrue(oneEditAway.oneAway("", "a"));
        Assertions.assertTrue(oneEditAway.oneAway("a", ""));
    }

    @Test
    void testMultipleMismatches() {
        Assertions.assertFalse(oneEditAway.oneAway("hint", "lints"));
        Assertions.assertFalse(oneEditAway.oneAway("hint", "hi"));
    }
}