package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MultiplyStringsTest {

    MultiplyStrings multiplyStrings = new MultiplyStrings();

    @Test
    void testMultiplyingStrings() {
        Assertions.assertEquals("6", multiplyStrings.multiply("2", "3"));
        Assertions.assertEquals("56088", multiplyStrings.multiply("123", "456"));
        Assertions.assertEquals("3980000", multiplyStrings.multiply("398", "10000"));
        Assertions.assertEquals("980000", multiplyStrings.multiply("098", "10000"));
        Assertions.assertEquals("0", multiplyStrings.multiply("00", "99"));
    }
}