package edu.bit.datastructures.graph;

import edu.bit.datastructures.trie.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A “word square” is an ordered sequence of K different words of length K that, when written one word per line, reads the same horizontally and vertically. For example:
 * BALL
 * AREA
 * LEAD
 * LADY
 * <p>
 * First, design a way to return true if a given sequence of words is a word square.
 * Second, given an arbitrary list of words, return all the possible word squares it contains. Reordering is allowed.
 * For example, the input list
 * <p>
 * [AREA, BALL, DEAR, LADY, LEAD, YARD]
 * <p>
 * should output
 * <p>
 * [(BALL, AREA, LEAD, LADY), (LADY, AREA, DEAR, YARD)]
 * <p>
 * If the input is really large — say 100B “words” and each word is 1K characters —
 * how would you design a distributed system to handle this?
 */
public class WordSquares {

    private TrieNode trie = new TrieNode();
    private String[] words;
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        for (int i = 0; i < words.length; ++i) {
            trie.addWord(words[i]);
        }

        List<String> t = new ArrayList<>();
        for (String w : words) {
            t.add(w);
            dfs(t);
            t.remove(t.size() - 1);
        }
        return ans;
    }

    private void dfs(List<String> t) {
        if (t.size() == words[0].length()) {
            ans.add(new ArrayList<>(t));
            return;
        }
        int idx = t.size();
        StringBuilder pref = new StringBuilder();
        for (String x : t) {
            pref.append(x.charAt(idx));
        }
        List<Integer> indexes = trie.search(pref.toString());
        for (int i : indexes) {
            t.add(words[i]);
            dfs(t);
            t.remove(t.size() - 1);
        }
    }

    public boolean validWordSquare(List<String> words) {
        int m = words.size();
        for (int i = 0; i < m; ++i) {
            int n = words.get(i).length();
            for (int j = 0; j < n; ++j) {
                if (j >= m || i >= words.get(j).length()) {
                    return false;
                }
                if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}