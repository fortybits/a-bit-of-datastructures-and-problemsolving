package edu.bit.datastructures.stack;

/**
 * You are given a string s consisting of lowercase English letters.
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.
 * It can be proven that the answer is unique.
 */
public class RemoveAdjacentDuplicates {

    // push characters to stack, for any duplicate don't push it,
    // but as soon as a non matching character is found pop the top character
    public String removeDuplicatesUsingStack(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeDuplicates(String s) {
        int i = 0;
        int n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) {// count = 2
                i -= 2;
            }
        }
        return new String(res, 0, i);
    }

}