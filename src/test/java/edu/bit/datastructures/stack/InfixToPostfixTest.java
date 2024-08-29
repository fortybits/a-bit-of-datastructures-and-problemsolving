package edu.bit.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InfixToPostfixTest {

    InfixToPostfix infixToPostfix = new InfixToPostfix();

    @Test
    void testInfixToPostFix() {
        Assertions.assertEquals("ABC*+D+", infixToPostfix.infixToPostfix("A+B*C+D"));
        Assertions.assertEquals("AB+CDE/*-F+", infixToPostfix.infixToPostfix("((A+B)–C*(D/E))+F"));
        Assertions.assertEquals("abcd^e-fgh*+^*+i-", infixToPostfix.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

}