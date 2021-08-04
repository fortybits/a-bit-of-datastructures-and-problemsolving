package edu.bit.datastructures.dp;

import edu.bit.annotations.organisation.Google;
import edu.bit.annotations.topics.DynamicProgramming;

import java.util.*;

@Google
@DynamicProgramming
public class LongestStringChain {

    // There is something about dynamic programming, that just doesn't come naturally to me while solving problems.
    // Goal: Solve one problem related to DP every day unless I can change myself on this!

    // Don't think of what is not coming to you, use what you are getting naturally instead.
    // DFS was one way to solve the approach

    public int longestStringChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        Arrays.sort(words, Comparator.comparingInt(String::length));  // Sort the words based on their lengths
        Map<String, Integer> map = new HashMap<>();       // Stores each word and length of its max chain.
        int res = 0;
        for (String w : words) {                             //From shortest word to longest word
            map.put(w, 1);                                  //Each word is atleast 1 chain long
            for (int i = 0; i < w.length(); i++) {               //Form next word removing 1 char each time for each w
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(i).toString();
                if (map.containsKey(next) && map.get(next) + 1 > map.get(w))
                    map.put(w, map.get(next) + 1);            //If the new chain is longer, update the map
            }
            res = Math.max(res, map.get(w));                //Store max length of all chains
        }
        return res;
    }

    public List<String> longestStrChainValues(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(words));
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            List<String> branches = helper(map, set, word);
            ans = ans.size() >= branches.size() ? ans : branches;
        }
        return ans;
    }

    private List<String> helper(Map<String, List<String>> map, Set<String> set, String word) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        List<String> cnt = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            String next = word.substring(0, i) + word.substring(i + 1);
            if (set.contains(next)) {
                List<String> helper = helper(map, set, next);
                cnt = cnt.size() >= helper.size() ? cnt : helper;
            }
        }
        map.merge(word, cnt, (str1, str2) -> {
            str1.addAll(str2);
            return str1;
        });
        return map.get(word);
    }


    public int dfs(HashSet<String> words, HashMap<String, Integer> cache, String s) {

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        int max = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            // creating all possible strings with one character taken out
            sb.deleteCharAt(i);
            String ns = sb.toString();
            if (words.contains(ns)) {
                max = Math.max(max, dfs(words, cache, ns));
            }
            // insertng it back for next iteration
            sb.insert(i, s.charAt(i));
        }
        cache.put(s, ++max);

        return max;
    }

    public int longestStrChain(String[] words) {
        HashMap<String, Integer> cache = new HashMap<>();

        HashSet<String> wordSet = new HashSet<>();
        for (String s : words) wordSet.add(s);

        int max = 0;
        for (String w : words) {
            max = Math.max(max, dfs(wordSet, cache, w));
            //System.out.println(w+ " - "+max);
        }
        return max;
    }

}