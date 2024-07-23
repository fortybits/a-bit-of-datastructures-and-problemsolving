package edu.bit.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidParenthesisTest {

    ValidParenthesis validParenthesis = new ValidParenthesis();

    @Test
    void testParenthesisBalancedOrNot() {
        Assertions.assertTrue(validParenthesis.isBalanced("()[]{}"));
        Assertions.assertFalse(validParenthesis.isBalanced("(]"));
        Assertions.assertTrue(validParenthesis.isBalanced("()"));
    }

}