package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatchSticksSquareTest {

    MatchSticksSquare matchSticksSquare = new MatchSticksSquare();

    @Test
    void testMakeSquare() {
        Assertions.assertTrue(matchSticksSquare.makeSquare(new int[]{1, 1, 2, 2, 2}));
        Assertions.assertTrue(matchSticksSquare.makeSquare(new int[]{13, 11, 1, 8, 6, 7, 8, 8, 6, 7, 8, 9, 8}));
        Assertions.assertFalse(matchSticksSquare.makeSquare(new int[]{3, 3, 3, 3, 4}));
    }
}