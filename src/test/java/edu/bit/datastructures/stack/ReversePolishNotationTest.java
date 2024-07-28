package edu.bit.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReversePolishNotationTest {

    ReversePolishNotation reversePolishNotation = new ReversePolishNotation();

    @Test
    void testEvalRPN() {
//        Assertions.assertEquals(22,
//                reversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        Assertions.assertEquals(6,
                reversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

}