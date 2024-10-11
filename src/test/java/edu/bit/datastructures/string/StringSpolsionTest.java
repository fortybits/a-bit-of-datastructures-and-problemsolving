package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringSpolsionTest {

    StringSpolsion stringSpolsion = new StringSpolsion();

    @Test
    void testStringSpolsion() {
        Assertions.assertEquals("CCoCodCode", stringSpolsion.stringSplosion("Code"));
        Assertions.assertEquals("aababc", stringSpolsion.stringSplosion("abc"));
    }

}