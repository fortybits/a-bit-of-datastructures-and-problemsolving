package edu.bit.datastructures.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class KClosestElementsTest {


    KClosestElements kClosestElements = new KClosestElements();

    @Test
    void testKClosestElements() {
        Assertions.assertEquals(List.of(1, 2, 3, 4),
                kClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
        Assertions.assertEquals(List.of(1, 2, 3, 4),
                kClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        Assertions.assertEquals(List.of(2, 3, 4, 5),
                kClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 6));
    }

}