package edu.bit.datastructures.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchInRotatedArrayTest {

    SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();

    @Test
    void testSearchInRotatedArray() {
        Assertions.assertEquals(4, searchInRotatedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assertions.assertEquals(-1, searchInRotatedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

}