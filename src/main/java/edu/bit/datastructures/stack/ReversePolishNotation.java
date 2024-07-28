package edu.bit.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * <p>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * <p>
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class ReversePolishNotation {

    // Idea is to continue processing the elements while adding them to a stack.
    // As soon as an operator is found, process the previous two numbers on stack first.
    public int evalRPN(String[] tokens) {
        Integer firstOperand, secondOperand;
        Stack<Integer> stackOfNumbers = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stackOfNumbers.add(stackOfNumbers.pop() + stackOfNumbers.pop());
            } else if (token.equals("/")) {
                secondOperand = stackOfNumbers.pop();
                firstOperand = stackOfNumbers.pop();
                stackOfNumbers.add(firstOperand / secondOperand);
            } else if (token.equals("*")) {
                stackOfNumbers.add(stackOfNumbers.pop() * stackOfNumbers.pop());
            } else if (token.equals("-")) {
                secondOperand = stackOfNumbers.pop();
                firstOperand = stackOfNumbers.pop();
                stackOfNumbers.add(firstOperand - secondOperand);
            } else {
                stackOfNumbers.add(Integer.parseInt(token));
            }
        }
        return stackOfNumbers.pop();
    }

}
