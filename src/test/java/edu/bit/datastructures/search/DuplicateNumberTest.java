package edu.bit.datastructures.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DuplicateNumberTest {

    DuplicateNumber duplicateNumber = new DuplicateNumber();

    @Test
    void testDuplicateNumber() {
        Assertions.assertEquals(2, duplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        Assertions.assertEquals(3, duplicateNumber.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        Assertions.assertEquals(3, duplicateNumber.findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }

}