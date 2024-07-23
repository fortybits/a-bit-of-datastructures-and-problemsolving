package edu.bit.datastructures.stack;

import java.util.LinkedList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParenthesis {

    public boolean isBalanced(final String charSequence) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : charSequence.toCharArray()) {
            if ((ch == '}' || ch == ')' || ch == ']') && stack.isEmpty()) return false;
            if (ch == '}' && stack.peek() != '{') return false;
            if (ch == ')' && stack.peek() != '(') return false;
            if (ch == ']' && stack.peek() != '[') return false;
            if ((ch == '{' || ch == '(' || ch == '[')) stack.push(ch);
            else stack.pop();
        }
        return stack.isEmpty();
    }
}
