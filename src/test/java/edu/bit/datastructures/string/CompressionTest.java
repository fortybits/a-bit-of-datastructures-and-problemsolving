package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompressionTest {

    Compression compression = new Compression();

    @Test
    void testStringCompression() {
        Assertions.assertEquals("abcde", compression.compressOptimised("abcde"));
        Assertions.assertEquals("a5b2d1e3", compression.compressOptimised("aaaaabbdeee"));
        Assertions.assertEquals("aaaaabcdef", compression.compressOptimised("aaaaabcdef"));
    }
}