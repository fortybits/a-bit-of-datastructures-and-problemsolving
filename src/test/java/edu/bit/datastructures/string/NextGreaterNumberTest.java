package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NextGreaterNumberTest {

    NextGreaterNumber nextGreaterNumber = new NextGreaterNumber();

    @Test
    void findNextGreaterNumber() {
        Assertions.assertEquals("123456785123446789", nextGreaterNumber.findNextGreaterNumber(
                new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '4', '9', '8', '7', '6', '5', '4', '3', '2', '1'}));
    }
}