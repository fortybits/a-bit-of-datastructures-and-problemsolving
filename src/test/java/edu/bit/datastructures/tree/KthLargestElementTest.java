package edu.bit.datastructures.tree;

import edu.bit.datastructures.sorting.KthLargestElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KthLargestElementTest {


    KthLargestElement largestElement = new KthLargestElement();

    @Test
    void testKthLargestElement() {
        Assertions.assertEquals(5,
                largestElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        Assertions.assertEquals(4,
                largestElement.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}