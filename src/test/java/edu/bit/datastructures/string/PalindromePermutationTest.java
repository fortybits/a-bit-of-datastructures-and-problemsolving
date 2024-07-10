package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromePermutationTest {

    PalindromePermutation palindromePermutation = new PalindromePermutation();

    @Test
    void testPalindromePermutation() {
        Assertions.assertTrue(palindromePermutation.palindromePermutation("tacocat"));
        Assertions.assertFalse(palindromePermutation.palindromePermutation("nobother"));
    }

}