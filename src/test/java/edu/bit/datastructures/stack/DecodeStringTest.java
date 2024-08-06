package edu.bit.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecodeStringTest {

    DecodeString decodeString = new DecodeString();

    @Test
    void testDecodeString() {
        Assertions.assertEquals("aaabcbc", decodeString.decodeString("3[a]2[bc]"));
        Assertions.assertEquals("accaccacc", decodeString.decodeString("3[a2[c]]"));
        Assertions.assertEquals("abcabccdcdcdef", decodeString.decodeString("2[abc]3[cd]ef"));
    }
}