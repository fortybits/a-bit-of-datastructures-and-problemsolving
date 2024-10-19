package edu.bit.datastructures.tree;

import java.util.*;

/**
 * Given a string S and a set of words D, find the longest word in D that is a subsequence of S.
 * <p>
 * Word W is a subsequence of S if some number of characters, possibly zero, can be deleted from S to form W, without reordering the remaining characters.
 * <p>
 * Note: D can appear in any format (list, hash table, prefix tree, etc.
 * <p>
 * For example, given the input of S = "abppplee" and D = {"able", "ale", "apple", "bale", "kangaroo"} the correct output would be "apple"
 * <p>
 * The words "able" and "ale" are both subsequences of S, but they are shorter than "apple".
 * The word "bale" is not a subsequence of S because even though S has all the right letters, they are not in the right order.
 * The word "kangaroo" is the longest word in D, but it isn't a subsequence of S.
 */
public class LongestWord {


    // brute force way would be to perform [D*K]*S operations to match the strings
    // a better approach could be to generate all the combinations of S 2^S complexity and checking if D contains any (max length)

    // alternatively one can sort the words provided and reduce the time complexity
    static String longestWord(List<String> d, String str) {

        // sort the dictionary word
        // for smallest lexicographical order
        Collections.sort(d);

        for (String c : d) {
            check(c, str);
        }

        return res;
    }

    static String res = "";

    static void check(String d, String s) {

        int i = 0;
        int j = 0;
        while (i < d.length() && j < s.length()) {

            if (d.charAt(i) == s.charAt(j)) {
                i += 1;
                j += 1;
            } else j += 1;

            if (i == d.length() && res.length() < d.length()) {
                res = d;
            }
        }
    }


    static class Tuple {
        String word;
        int index;

        Tuple(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public static String findLongestWordInString(String letters, String[] words) {
        // Corner Case: Either one of them is empty.
        if (letters.isEmpty() || words.length == 0) {
            return " ";
        }

        Map<Character, Set<Tuple>> letterPositions = new HashMap<>();
        // Initialize the data structure. Filter out any empty words that may appear in the words list.
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            letterPositions.computeIfAbsent(word.charAt(0), k -> new HashSet<>())
                    .add(new Tuple(word, 0));
        }

        String longestWord = "";
        for (char c : letters.toCharArray()) {
            if (!letterPositions.containsKey(c)) {
                continue;
            }
            Set<Tuple> currPositions = new HashSet<>(letterPositions.get(c));
            for (Tuple pair : currPositions) {
                String currWord = pair.word;
                pair.index++;
                // Remove the pair from the set
                letterPositions.get(c).remove(pair);
                // We found a subsequence.
                if (currWord.length() == pair.index) {
                    if (currWord.length() > longestWord.length()) {
                        longestWord = currWord;
                    }
                } else {
                    letterPositions.computeIfAbsent(currWord.charAt(pair.index), k -> new HashSet<>()).add(pair);
                }
            }
        }
        return longestWord;
    }
}