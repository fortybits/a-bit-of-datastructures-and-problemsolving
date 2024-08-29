package edu.bit.datastructures.stack;

import java.util.Stack;

/**
 * Write a program to convert an Infix expression to Postfix form.
 * <p>
 * Infix expression: The expression of the form “a operator b” (a + b) i.e., when an operator is in-between every pair of operands.
 * Postfix expression: The expression of the form “a b operator” (ab+) i.e., When every pair of operands is followed by an operator.
 * <p>
 * Input: A + B * C + D
 * Output: ABC*+D+
 * <p>
 * Input: ((A + B) – C * (D / E)) + F
 * Output: AB+CDE/*-F+
 */
public class InfixToPostfix {

    // The main function to convert infix expression to postfix expression
    public String infixToPostfix(String infixExp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExp.length(); i++) {
            char c = infixExp.charAt(i);

            // If the scanned character is an operand, add it to the output string.
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result.append(c);
            }
            // If the scanned character is an ‘(‘, push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and add to the output string from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop '('
            }
            // If an operator is scanned
            else {
                while (!stack.isEmpty() && (precedence(infixExp.charAt(i)) < precedence(stack.peek()) ||
                        precedence(infixExp.charAt(i)) == precedence(stack.peek()) && associativity(infixExp.charAt(i)) == 'L')) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining elements from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }


    // Function to return precedence of operators
    static int precedence(char c) {
        return switch (c) {
            case '^' -> 3;
            case '/', '*' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    // Function to return associativity of operators
    static char associativity(char c) {
        // Default to left-associative
        return c == '^' ? 'R' : 'L';
    }
}