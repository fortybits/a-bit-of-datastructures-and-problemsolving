package edu.bit.datastructures.array;

import java.util.*;

/**
 * You are receiving a sequence of characters. At any point in time, when you are queried,
 * you should be able to give the earliest non-repeating character.
 * Eg.
 * a, b, a, c, d, a, c, b, a
 * 0  1  2  3  4  5  6  7  8
 * a  a  b  b  b  b  b  d  d
 */
public class EarlierNonRepeatingCharacter {

    // The approach is to maintain a hashset for the characters visited and a queue for first in first out lookup.
    //  [a,b,c,d] // find what ever has been visited
    //  [a] [a,b] [b] [b,c] [b,c,d] [b,c,d] [b,d] [d] // queue for lookup
    //                            |__________|

    Queue<Character> candidates;
    Set<Character> visited;

    EarlierNonRepeatingCharacter() {
        visited = new HashSet<>();
        candidates = new ArrayDeque<>();
    }

    public void processLastAdded(char latest) {
        if (visited.contains(latest)) {
            candidates.remove(latest);
        } else {
            visited.add(latest);
            candidates.add(latest);
        }
    }

    public Character findEarliestNonRepeatingCharacter() {
        if (candidates.isEmpty()) {
            return null;
        } else {
            return candidates.peek();
        }
    }

    // lookups here are optimised to perform at O(1) while processing takes a hit at O(N^2) with queue.remove
    private void processStreamOfCharacterForNoRepeatingCharacter(List<Character> characters) {
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new ArrayDeque<>();
        for (Character ch : characters) {
            if (visited.contains(ch)) {
                queue.remove(ch);
            } else {
                visited.add(ch);
                queue.add(ch);
            }
        }
    }

    // lookups here are not optimised to perform at O(1) while the processing is O(N)
    public Character getFirstNonRepeatingCharacter(List<Character> characters) {
        // LinkedHashMap maintains insertion order
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character ch : characters) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return null;
    }
}