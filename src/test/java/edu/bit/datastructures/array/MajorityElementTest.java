package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MajorityElementTest {

    MajorityElement majorityElement = new MajorityElement();

    @Test
    void testMajorityElementBasic() throws IllegalAccessException {
        Assertions.assertEquals(2, majorityElement.majorityElement(new int[]{2, 1, 2}));
        Assertions.assertEquals(3, majorityElement.majorityElement(new int[]{3, 1, 2, 3, 3, 1, 3}));
    }

    @Test
    void testMajorityElementForNegativeCase() {
        IllegalAccessException illegalAccessException = Assertions.assertThrows(
                IllegalAccessException.class, () -> majorityElement.majorityElement(new int[]{3, 1, 2, 3, 3, 2}));
    }
}