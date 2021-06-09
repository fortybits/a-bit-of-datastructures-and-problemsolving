package edu.bit.datastructures.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JumpGameMaximumScoreTest {

    JumpGameMaximumScore jumpGameMaximumScore = new JumpGameMaximumScore();

    @Test
    void testMaxResult() {
        Assertions.assertEquals(7,
                jumpGameMaximumScore.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        Assertions.assertEquals(17,
                jumpGameMaximumScore.maxResult(new int[]{10, -5, -2, 4, 0, 3}, 3));
        Assertions.assertEquals(0,
                jumpGameMaximumScore.maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
        Assertions.assertEquals(1,
                jumpGameMaximumScore.maxResult(new int[]{1, -5, -3, -7, 3}, 3));
        Assertions.assertEquals(-1,
                jumpGameMaximumScore.maxResult(new int[]{0, -1, -2, -3, 1}, 2));
    }

    @Test
    void testMaxResultOpt() {
        Assertions.assertEquals(7,
                jumpGameMaximumScore.maxResultOpt(new int[]{1, -1, -2, 4, -7, 3}, 2));
        Assertions.assertEquals(17,
                jumpGameMaximumScore.maxResultOpt(new int[]{10, -5, -2, 4, 0, 3}, 3));
        Assertions.assertEquals(0,
                jumpGameMaximumScore.maxResultOpt(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
        Assertions.assertEquals(1,
                jumpGameMaximumScore.maxResultOpt(new int[]{1, -5, -3, -7, 3}, 3));
        Assertions.assertEquals(-1,
                jumpGameMaximumScore.maxResultOpt(new int[]{0, -1, -2, -3, 1}, 2));
    }
}