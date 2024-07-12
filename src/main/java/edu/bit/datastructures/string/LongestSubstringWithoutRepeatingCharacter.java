package edu.bit.datastructures.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacter {

    // we can keep sliding the window with the starting point unchanged unless
    // we find the repeating character and at that point in time
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charToLastIndexMap = new HashMap<>();
        int maxLength = 0;
        for (int i = 0, slidingStartPointer = 0; i < s.length(); ++i) {
            if (charToLastIndexMap.containsKey(s.charAt(i))) {
                slidingStartPointer = Math.max(slidingStartPointer, charToLastIndexMap.get(s.charAt(i)) + 1);
            }
            charToLastIndexMap.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - slidingStartPointer + 1);
        }
        return maxLength;
    }

    // an optimisation on the queue approach, since performing contains check on queue would be O(N^2)
    public int lengthOfLongestSubstringUsingSetForQueue(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}