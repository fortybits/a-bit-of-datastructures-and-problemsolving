package edu.bit.datastructures.tree;

import java.util.List;

/**
 * In English, we have a concept called root,
 * which can be followed by some other word to form another longer word -
 * let's call this word successor. For example, when the root "an" is followed
 * by the successor word "other", we can form a new word "another".
 * <p>
 * Given a dictionary consisting of many roots and a sentence consisting of words
 * separated by spaces, replace all the successors in the sentence with the root forming it.
 * If a successor can be replaced by more than one root,
 * replace it with the root that has the shortest length.
 * <p>
 * Return the sentence after the replacement.
 */
public class ReplaceWords {

    // N words in a sentence with M being the length of each word
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] tokens = sentence.split(" ");
        TrieNode trie = buildTrie(dictionary);
        return replaceWords(tokens, trie);
    }

    private String replaceWords(String[] tokens, TrieNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String token : tokens) {
            stringBuilder.append(getShortestReplacement(token, root))
                    .append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private String getShortestReplacement(String token, final TrieNode root) {
        TrieNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : token.toCharArray()) {
            stringBuilder.append(c);
            if (temp.children[c - 'a'] != null) {
                if (temp.children[c - 'a'].isWord) {
                    return stringBuilder.toString();
                }
                temp = temp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for (String word : dict) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }

    /**
     * optimise the dictionary to consist of unique elements based on theire prefixes Set<String>
     * for (word: sentence) {
     * int (i = 0;i<word.length;i++){
     * substring is present in the set, then use he prefix and break
     * }
     * }
     * this would end up being N*M
     */


    // optimisation that is possible here is based on the M characters that we are iterating,
    // we can match to a trie based lookup (same as we do in a real life dictionary)
    // trie for dictionary would help in comparison here with word
    public class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

}