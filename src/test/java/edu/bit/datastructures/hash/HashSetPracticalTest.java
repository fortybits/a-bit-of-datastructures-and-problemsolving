package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashSetPracticalTest {

    HashSetPractical hashSetPractical = new HashSetPractical();

    @Test
    void testContainsDuplicate() {
        Assertions.assertTrue(hashSetPractical.containsDuplicate(new int[]{1, 2, 3, 1}));
        Assertions.assertFalse(hashSetPractical.containsDuplicate(new int[]{1, 2, 3, 4}));
        Assertions.assertTrue(hashSetPractical.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));

    }

    @Test
    void testSingleNumber() {
        Assertions.assertEquals(1, hashSetPractical.singleNumber(new int[]{2, 2, 1}));
        Assertions.assertEquals(4, hashSetPractical.singleNumber(new int[]{4, 1, 2, 1, 2}));
        Assertions.assertEquals(1, hashSetPractical.singleNumber(new int[]{1}));
    }
}