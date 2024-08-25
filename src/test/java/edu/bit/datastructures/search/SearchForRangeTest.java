package edu.bit.datastructures.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchForRangeTest {

    SearchForRange searchForRange = new SearchForRange();

    @Test
    void testSearchForRange() {
        Assertions.assertArrayEquals(new int[]{3, 4},
                searchForRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));

        Assertions.assertArrayEquals(new int[]{-1, -1},
                searchForRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));

        Assertions.assertArrayEquals(new int[]{-1, -1},
                searchForRange.searchRange(new int[]{}, 0));
    }

}