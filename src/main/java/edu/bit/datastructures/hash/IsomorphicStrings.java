package edu.bit.datastructures.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Character> sTot = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sTot.containsKey(sChars[i])) {
                if (sTot.get(sChars[i]) != tChars[i])
                    return false; // a character in 's' should be mapped to the same character in 't'
            } else {
                if (tTos.containsKey(tChars[i])) { // a character from 't' once mapped with a character in 's' should not be mapped with anything else
                    if (tTos.get(tChars[i]) != sChars[i]) return false;
                } else {
                    sTot.put(sChars[i], tChars[i]); // construct both lookups
                    tTos.put(tChars[i], sChars[i]);
                }
            }
        }
        return true;
    }
}