package edu.bit.datastructures.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LetterCombinationTest {

    LetterCombination letterCombination = new LetterCombination();

    @Test
    void testLetterCombinations() {
        Assertions.assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
                letterCombination.letterCombinationsWithFIFO("23"));

        Assertions.assertEquals(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
                letterCombination.letterCombinations("23"));
    }
}