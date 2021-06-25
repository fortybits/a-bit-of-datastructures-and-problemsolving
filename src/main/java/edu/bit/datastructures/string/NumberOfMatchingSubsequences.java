package edu.bit.datastructures.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 * <p>
 * A subsequence of a string is a new string generated from the original string with
 * some characters (can be none) deleted without changing the relative order of the remaining characters.
 * <p>
 * For example, "ace" is a subsequence of "abcde".
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubsequence(String s, String[] words) {
        List<Integer[]>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++) {
            waiting[c] = new ArrayList<>();
        }
        for (int i = 0; i < words.length; i++) {
            waiting[words[i].charAt(0)].add(new Integer[]{i, 1});
        }
        for (char c : s.toCharArray()) {
            List<Integer[]> advance = new ArrayList<>(waiting[c]);
            waiting[c].clear();
            for (Integer[] a : advance) {
                waiting[a[1] < words[a[0]].length() ? words[a[0]].charAt(a[1]++) : 0].add(a);
            }
        }
        return waiting[0].size();
    }
}
