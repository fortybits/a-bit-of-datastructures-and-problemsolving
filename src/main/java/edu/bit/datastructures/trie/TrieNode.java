package edu.bit.datastructures.trie;

import java.util.*;

public class TrieNode {
    private final Map<Character, TrieNode> children;
    private final List<Integer> indexes;
    private boolean terminates = false;
    // The character stored in this node as data.
    private char character;

    public TrieNode() {
        children = new HashMap<>();
        indexes = new ArrayList<>();
    }

    /* Constructs a trie node and stores in the node the char passed in
     * as the argument. Initializes the list of child nodes of this
     * node to an empty hash map.
     */
    public TrieNode(char character) {
        this();
        this.character = character;
    }


    public void insertString(String s, int index) {
        if (s == null) return;
        indexes.add(index);
        if (s.length() > 0) {
            char value = s.charAt(0);
            TrieNode child = null;
            if (children.containsKey(value)) {
                child = children.get(value);
            } else {
                child = new TrieNode();
                children.put(value, child);
            }
            String remainder = s.substring(1);
            child.insertString(remainder, index + 1);
        } else {
            children.put('\0', null);
        }
    }

    public List<Integer> search(String s) {
        if (s == null || s.length() == 0) {
            return indexes;
        } else {
            char first = s.charAt(0);
            if (children.containsKey(first)) {
                String remainder = s.substring(1);
                return children.get(first).search(remainder);
            }
        }
        return Collections.emptyList();
    }

    /* Add this word to the trie, and recursively create the child
     * nodes. */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        char firstChar = word.charAt(0);

        TrieNode child = getChild(firstChar);
        if (child == null) {
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }

        if (word.length() > 1) {
            child.addWord(word.substring(1));
        } else {
            child.setTerminates(true);
        }
    }

    /* Find a child node of this node that has the char argument as its
     * data. Return null if no such child node is present in the trie.
     */
    public TrieNode getChild(char c) {
        return children.get(c);
    }

    /* Returns whether this node represents the end of a complete word. */
    public boolean terminates() {
        return terminates;
    }

    /* Set whether this node is the end of a complete word.*/
    public void setTerminates(boolean t) {
        terminates = t;
    }
}
