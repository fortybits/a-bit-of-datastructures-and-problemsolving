package edu.bit.datastructures.dp;

import edu.bit.annotations.topics.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@DynamicProgramming
public class LongestStringChainLength {

    public int longestStringChainLength(String[] dictionary) {
        if (dictionary == null || dictionary.length == 0) {
            return 0;
        }

        Arrays.sort(dictionary, Comparator.comparingInt(String::length));  // Sort the words based on their lengths
        Map<String, Integer> wordToChainLength = new HashMap<>();       // Stores each word and length of its max chain.
        int result = 0;
        for (String word : dictionary) {                             //From shortest word to longest word
            wordToChainLength.put(word, 1);                                  //Each word is atleast 1 chain long
            for (int i = 0; i < word.length(); i++) {               //Form next word removing 1 char each time for each w
                String next = word.substring(0, i) + word.substring(i + 1);
                if (wordToChainLength.containsKey(next) &&
                        wordToChainLength.get(next) + 1 > wordToChainLength.get(word)) {
                    wordToChainLength.put(word, wordToChainLength.get(next) + 1);            //If the new chain is longer, update the map
                }
            }
            result = Math.max(result, wordToChainLength.get(word));                //Store max length of all chains
        }
        return result;
    }
}
