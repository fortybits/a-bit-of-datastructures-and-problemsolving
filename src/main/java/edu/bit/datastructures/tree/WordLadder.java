package edu.bit.datastructures.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using
 * a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from
 */
public class WordLadder {

    // the method uses the bfs approach but underlying within bidirectional search
    // the iteration of queue adds child to begin set and end set alternatively to ensure
    // half the work is done from both the ends
    public int ladderLengthWithBidirectionalSearch(String beginWord, String endWord, Set<String> dictionary) {
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        int len = 1;
        Set<String> visited = new HashSet<>();

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String target = word.substring(0, i) + c + word.substring(i + 1);
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && dictionary.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }


    public int ladderLengthUsingBFS(String beginWord, String endWord, Set<String> dictionary) {
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (dictionary.contains(word)) {
                            toAdd.add(word);
                            dictionary.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) { // no path
                return 0;
            }
            reached = toAdd;
        }
        return distance;
    }
}