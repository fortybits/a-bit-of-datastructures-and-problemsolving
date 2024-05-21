package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordDictionaryTest {

    WordDictionary wordDictionary;

    @Test
    void addAndSearchWord() {
        wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assertions.assertFalse(wordDictionary.search("pad"));
        Assertions.assertTrue(wordDictionary.search("bad"));
        Assertions.assertTrue(wordDictionary.search(".ad"));
        Assertions.assertFalse(wordDictionary.search("l.d"));
        Assertions.assertTrue(wordDictionary.search("b.."));
    }
}