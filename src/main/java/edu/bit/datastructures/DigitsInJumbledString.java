package edu.bit.datastructures;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a string s of length N, containing digits written in words but in jumbled form,
 * the task is to find out the digits present in the string in word form and arrange them in sorted order.
 * Input:  s = “ozerotwneozero”
 * Output: 0012
 * Explanation: The string can be arranged as “zerozeroonetwo”.
 * Therefore, the digits are 0, 0, 1 and 2.
 * <p>
 * Input:  s = “otwneotheer”
 * Output: 123
 */
public class DigitsInJumbledString {

    public String findNumber(String input) {
        // Stores the final ans
        StringBuilder answer = new StringBuilder();

        // Stores the corresponding character from the word with its frequency
        Map<Character, Long> characterLookup = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        for (char i = 'a'; i <= 'z'; i++) {
            characterLookup.putIfAbsent(i, 0L);
        }

        while (characterLookup.get('z') != 0 && characterLookup.get('e') != 0
                && characterLookup.get('r') != 0 && characterLookup.get('o') != 0) {
            characterLookup.put('z', characterLookup.get('z') - 1);
            characterLookup.put('e', characterLookup.get('e') - 1);
            characterLookup.put('r', characterLookup.get('r') - 1);
            characterLookup.put('o', characterLookup.get('o') - 1);
            answer.append("zero");
        }
        while (characterLookup.get('o') != 0 && characterLookup.get('n') != 0
                && characterLookup.get('e') != 0) {
            characterLookup.put('o', characterLookup.get('o') - 1);
            characterLookup.put('n', characterLookup.get('n') - 1);
            characterLookup.put('e', characterLookup.get('e') - 1);
            answer.append("one");
        }
        while (characterLookup.get('t') != 0 && characterLookup.get('w') != 0
                && characterLookup.get('o') != 0) {
            characterLookup.put('t', characterLookup.get('t') - 1);
            characterLookup.put('w', characterLookup.get('w') - 1);
            characterLookup.put('o', characterLookup.get('o') - 1);
            answer.append("two");
        }
        while (characterLookup.get('t') != 0 && characterLookup.get('h') != 0
                && characterLookup.get('r') != 0 && characterLookup.get('e') >= 2) {
            characterLookup.put('t', characterLookup.get('t') - 1);
            characterLookup.put('h', characterLookup.get('h') - 1);
            characterLookup.put('r', characterLookup.get('r') - 1);
            characterLookup.put('e', characterLookup.get('e') - 1);
            characterLookup.put('e', characterLookup.get('e') - 1);
            answer.append("three");
        }
        while (characterLookup.get('f') != 0 && characterLookup.get('o') != 0
                && characterLookup.get('u') != 0 && characterLookup.get('r') != 0) {
            characterLookup.put('f', characterLookup.get('f') - 1);
            characterLookup.put('o', characterLookup.get('o') - 1);
            characterLookup.put('u', characterLookup.get('u') - 1);
            characterLookup.put('r', characterLookup.get('r') - 1);
            answer.append("four");
        }
        while (characterLookup.get('f') != 0 && characterLookup.get('i') != 0
                && characterLookup.get('v') != 0 && characterLookup.get('e') != 0) {
            characterLookup.put('f', characterLookup.get('f') - 1);
            characterLookup.put('i', characterLookup.get('i') - 1);
            characterLookup.put('v', characterLookup.get('v') - 1);
            characterLookup.put('e', characterLookup.get('e') - 1);
            answer.append("five");
        }
        while (characterLookup.get('s') != 0 && characterLookup.get('i') != 0
                && characterLookup.get('x') != 0) {
            characterLookup.put('s', characterLookup.get('s') - 1);
            characterLookup.put('i', characterLookup.get('i') - 1);
            characterLookup.put('x', characterLookup.get('x') - 1);
            answer.append("six");
        }
        while (characterLookup.get('s') != 0 && characterLookup.get('v') != 0
                && characterLookup.get('e') >= 2 && characterLookup.get('n') != 0) {
            characterLookup.put('s', characterLookup.get('s') - 1);
            characterLookup.put('e', characterLookup.get('e') - 1);
            characterLookup.put('v', characterLookup.get('v') - 1);
            characterLookup.put('e', characterLookup.get('e') - 1);
            characterLookup.put('n', characterLookup.get('n') - 1);
            answer.append("seven");
        }
        while (characterLookup.get('e') != 0 && characterLookup.get('i') != 0
                && characterLookup.get('g') != 0 && characterLookup.get('h') != 0
                && characterLookup.get('t') != 0) {
            characterLookup.put('e', characterLookup.get('e') - 1);
            characterLookup.put('i', characterLookup.get('i') - 1);
            characterLookup.put('g', characterLookup.get('g') - 1);
            characterLookup.put('h', characterLookup.get('h') - 1);
            characterLookup.put('t', characterLookup.get('t') - 1);
            answer.append("eight");
        }
        while (characterLookup.get('n') >= 2 && characterLookup.get('i') != 0
                && characterLookup.get('e') != 0) {
            characterLookup.put('n', characterLookup.get('n') - 1);
            characterLookup.put('i', characterLookup.get('i') - 1);
            characterLookup.put('n', characterLookup.get('n') - 1);
            characterLookup.put('e', characterLookup.get('e') - 1);
            answer.append("nine");
        }
        return answer.toString();
    }
}