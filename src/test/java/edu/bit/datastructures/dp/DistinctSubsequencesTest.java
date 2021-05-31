package edu.bit.datastructures.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DistinctSubsequencesTest {

    DistinctSubsequences distinctSubsequences = new DistinctSubsequences();

    @Test
    void testNumberOfDistinctSubsequences() {
        Assertions.assertEquals(3,
                distinctSubsequences.numberOfDistinctSubsequences("rabbbit", "rabbit"));

        Assertions.assertEquals(0,
                distinctSubsequences.numberOfDistinctSubsequences("", "rabbit"));

        Assertions.assertEquals(1,
                distinctSubsequences.numberOfDistinctSubsequences("asdasd", ""));

        Assertions.assertEquals(5,
                distinctSubsequences.numberOfDistinctSubsequences("babgbag", "bag"));


        Assertions.assertEquals(3,
                distinctSubsequences.numDistinctRecursion("rabbbit", "rabbit"));

        Assertions.assertEquals(0,
                distinctSubsequences.numDistinctRecursion("", "rabbit"));

        Assertions.assertEquals(1,
                distinctSubsequences.numDistinctRecursion("asdasd", ""));

        Assertions.assertEquals(5,
                distinctSubsequences.numDistinctRecursion("babgbag", "bag"));
    }
}