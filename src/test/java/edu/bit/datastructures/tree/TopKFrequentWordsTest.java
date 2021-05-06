package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TopKFrequentWordsTest {

    TopKFrequentWords topKFrequentWords = new TopKFrequentWords();

    @Test
    void testTopKFrequentElementsWithConflicts() {
        Assertions.assertEquals(List.of("i", "love"),
                topKFrequentWords.topKFrequent(
                        new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));

        Assertions.assertEquals(List.of("cinema", "i"),
                topKFrequentWords.topKFrequent(new String[]{"i", "love", "zee", "cinema"}, 2));

        Assertions.assertEquals(List.of("cinema", "i", "love", "zee"),
                topKFrequentWords.topKFrequent(new String[]{"i", "love", "zee", "cinema"}, 4));
    }

    @Test
    void testTopKFrequentElementsWithoutConflicts() {
        Assertions.assertEquals(List.of("i", "love"),
                topKFrequentWords.topKFrequent(
                        new String[]{"i", "love", "leetcode", "i", "love", "coding", "i"}, 2));
        Assertions.assertEquals(List.of("the", "is", "sunny", "day"),
                topKFrequentWords.topKFrequent(
                        new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));

    }
}