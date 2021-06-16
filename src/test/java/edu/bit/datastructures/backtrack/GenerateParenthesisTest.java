package edu.bit.datastructures.backtrack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GenerateParenthesisTest {

    GenerateParenthesis generateParenthesis = new GenerateParenthesis();

    @Test
    void generateParenthesis() {
        Assertions.assertEquals(List.of("((()))", "(()())", "(())()", "()(())", "()()()"),
                generateParenthesis.generateParenthesis(3));
        Assertions.assertEquals(List.of("()"),
                generateParenthesis.generateParenthesis(1));
    }
}