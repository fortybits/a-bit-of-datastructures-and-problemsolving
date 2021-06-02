package edu.bit.datastructures.string;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * <p>
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 */
public class InterleavingStrings {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        return depthFirstSearch(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    private boolean depthFirstSearch(char[] first, char[] second, char[] third, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) {
            return false;
        }
        if (k == third.length) {
            return true;
        }
        boolean firstMatches = i < first.length && first[i] == third[k] && depthFirstSearch(first, second, third, i + 1, j, k + 1, invalid);
        boolean secondMatches = j < second.length && second[j] == third[k] && depthFirstSearch(first, second, third, i, j + 1, k + 1, invalid);
        boolean valid = firstMatches || secondMatches;
        if (!valid) {
            invalid[i][j] = true; // character in target didn't match any of the source strings
        }
        return valid;
    }

    // we can also approach the problem via dynamic programming
    public boolean isInterleaveDP(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];

        matrix[0][0] = true; // base case, not considering anything from any source
        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))
                        || (matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        return matrix[s2.length()][s1.length()];
    }

}
