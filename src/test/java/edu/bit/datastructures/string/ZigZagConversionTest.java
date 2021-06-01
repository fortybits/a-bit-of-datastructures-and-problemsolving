package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ZigZagConversionTest {

    ZigZagConversion zigZagConversion = new ZigZagConversion();

    @Test
    void convertToZigZag() {
        Assertions.assertEquals("PAHNAPLSIIGYIR",
                zigZagConversion.convertToZigZag("PAYPALISHIRING", 3));

        Assertions.assertEquals("PINALSIGYAHRPI",
                zigZagConversion.convertToZigZag("PAYPALISHIRING", 4));

        Assertions.assertEquals("PAYPALISHIRING",
                zigZagConversion.convertToZigZag("PAYPALISHIRING", 14));

        Assertions.assertEquals("A",
                zigZagConversion.convertToZigZag("A", 1));
    }
}