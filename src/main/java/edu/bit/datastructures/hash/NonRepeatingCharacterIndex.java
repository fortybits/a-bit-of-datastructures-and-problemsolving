package edu.bit.datastructures.hash;

import java.util.*;

/**
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 * <p>
 * 1 <= s.length <= 10^5
 */
public class NonRepeatingCharacterIndex {

    public int firstUniqueCharIndex(String s) {
        Map<Character, Integer> nonRepeatingToIndex = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (nonRepeatingToIndex.containsKey(c)) {
                nonRepeatingToIndex.put(c, -1);
            } else {
                nonRepeatingToIndex.put(c, i);
            }
        }
        Optional<Integer> min = nonRepeatingToIndex.values()
                .stream()
                .filter(a -> a != -1)
                .min(Integer::compareTo);
        return min.orElse(-1);
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
