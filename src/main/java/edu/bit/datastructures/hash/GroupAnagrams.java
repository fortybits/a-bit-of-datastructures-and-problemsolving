package edu.bit.datastructures.hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams =
                Arrays.stream(strs).collect(Collectors.groupingBy(this::hashString));
        return new ArrayList<>(groupedAnagrams.values());
    }

    private String hashString(String str) {
        return str.chars().mapToObj(c -> (char) c)
                .sorted(Comparator.naturalOrder())
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public List<List<String>> groupAnagramsOptimised(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //char type 0~127 is enough for constraint 0 <= strs[i].length <= 100
            //char array to String is really fast, thanks @legendaryengineer
            //You should use other data type when length of string is longer.
            //E.g. Use byte (-128 to 127), short (-32,768 to 32,767),
            //int. -2,147,483,648 to 2,147,483,647
            char[] frequencyArr = new char[26];
            for (int i = 0; i < s.length(); i++) {
                frequencyArr[s.charAt(i) - 'a']++;
            }
            //6 ms use char(0~127) array and new String(frequencyArr) method.
            //17ms when use byte (-128 to 127) array and Arrays.toString(frequencyArr) method
            //29ms when use int(-2,147,483,648 to 2,147,483,647) and Arrays.toString(frequencyArr) method
            String key = new String(frequencyArr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key, tempList);
        }
        return new LinkedList<>(map.values());
    }
}