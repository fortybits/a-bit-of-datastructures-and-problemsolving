package edu.bit.datastructures.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindPeakElementsTest {

    FindPeakElements findPeakElements = new FindPeakElements();

    @Test
    void testFindPeakElements() {
        Assertions.assertEquals(2, findPeakElements.findPeakElement(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(5, findPeakElements.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));

    }

}