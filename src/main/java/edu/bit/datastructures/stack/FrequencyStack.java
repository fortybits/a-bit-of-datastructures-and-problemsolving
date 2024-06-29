package edu.bit.datastructures.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 * <p>
 * Implement the FreqStack class:
 * <p>
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 */
public class FrequencyStack {

    /**
     * Hash map `freq` will count the frequency of elements.
     * Hash map `m` is a map of stack. If element x has n frequence, we will push x n times in m[1], m[2] .. m[n]
     * `maxfreq` records the maximum frequency.
     * <p>
     * push(x) will push x tom[++freq[x]]
     * pop() will pop from the m[maxfreq]
     */
    Map<Integer, Integer> freq = new HashMap<>();
    Map<Integer, Stack<Integer>> m = new HashMap<>();
    int maxFreq = 0;

    public void push(int x) {
        int f = freq.merge(x, 1, Integer::sum);
        maxFreq = Math.max(maxFreq, f);
        m.computeIfAbsent(f, k -> new Stack<>()).add(x);
    }

    public int pop() {
        int x = m.get(maxFreq).pop();
        freq.put(x, maxFreq - 1);
        if (m.get(maxFreq).isEmpty()) maxFreq--;
        return x;
    }
}