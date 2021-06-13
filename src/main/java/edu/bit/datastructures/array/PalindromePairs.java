package edu.bit.datastructures.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
 * so that the concatenation of the two words words[i] + words[j] is a palindrome.
 */
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        // naive approach would be iterating through each word in the input and
        // then following through the rest of the array to append and check a palindrome
        // for(String word : words) ... for(words except word) concatenate and execute is Palindrome
        // this would be O(N^2) considering N to be the number of words

        // we shall think in the direction of the characters involved in the strings as well, that might help optimise
        //        How could AB be palindrome?
        //                If B ends with x, then A must starts with x.
        //                If the second last character of B is y, then the second last character of A is y...
        //        That is,
        //        Case 1. A must be prefix of reversed B, and the rest of reversed B should be palindrome. For example,
        //        (B:oooabc - cbaooo,    A:cba       AB:cba|oooabc)
        //        Case 2. Or, reversed B must be prefix of A, and the rest of A should be palindrome. For example,
        //        (B:abc - cba           A:cbaooo,   AB:cbaooo|abc)
        List<List<Integer>> ret = new ArrayList<>();
        if (words == null || words.length < 2) {
            return ret;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) { // notice it should be "j <= words[i].length()" for empty strings
                String oneHalf = words[i].substring(0, j);
                String otherHalf = words[i].substring(j);
                if (isPalindrome(oneHalf)) {
                    String str2rvs = new StringBuilder(otherHalf).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        ret.add(List.of(map.get(str2rvs), i));
                    }
                }
                if (isPalindrome(otherHalf)) {
                    String str1rvs = new StringBuilder(oneHalf).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && otherHalf.length() != 0) {
                        ret.add(List.of(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return ret;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
