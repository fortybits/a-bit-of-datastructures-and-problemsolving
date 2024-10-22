package edu.bit.datastructures.trie;

import java.util.HashMap;
import java.util.Map;

public class CustomTrie {

    TrieNode root;

    public CustomTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        root.addWord(word);
    }

    public boolean search(String word) {
        return root.search(word);
    }

    public boolean startsWith(String prefix) {
        TrieNode lastNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getChild(prefix.charAt(i));
            if (lastNode == null) {
                return false;
            }
        }
        return !lastNode.terminates;
    }

    class TrieNode {
        boolean terminates;
        char character;
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
            terminates = false;
        }

        TrieNode(char character) {
            this();
            this.character = character;
        }

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

        private TrieNode getChild(char c) {
            return children.get(c);
        }

        private void setTerminates(boolean t) {
            terminates = t;
        }

        public boolean search(String s) {
            if (s == null || s.isEmpty()) {
                return this.terminates;
            } else {
                char first = s.charAt(0);
                if (children.containsKey(first)) {
                    String remainder = s.substring(1);
                    return children.get(first).search(remainder);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        CustomTrie obj = new CustomTrie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }
}