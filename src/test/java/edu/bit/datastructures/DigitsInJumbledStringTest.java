package edu.bit.datastructures;

import edu.bit.datastructures.string.DigitsInJumbledString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DigitsInJumbledStringTest {

    DigitsInJumbledString digitsInJumbledString = new DigitsInJumbledString();

    @Test
    void testJumbledStringNumbers() {
        Assertions.assertEquals("threeseven", digitsInJumbledString.findNumber("tsveenreeh"));
        Assertions.assertEquals("sevennine", digitsInJumbledString.findNumber("snienvene"));

    }
}