package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainsDuplicateTest {

    ContainsDuplicate containsDuplicate = new ContainsDuplicate();

    @Test
    void testContainsDuplicate() {
        Assertions.assertTrue(containsDuplicate.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        Assertions.assertTrue(containsDuplicate.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        Assertions.assertFalse(containsDuplicate.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

}