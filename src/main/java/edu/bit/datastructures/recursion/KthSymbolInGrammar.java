package edu.bit.datastructures.recursion;

/**
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row,
 * we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
 * Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 * 1 <= k <= 2n - 1
 */
public class KthSymbolInGrammar {

    // divide each string from previous length in two parts and then further replace all
    // consider a tree, and relate to a level order traversal where kth element is to be returned
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        if (k % 2 == 0) {
            if (kthGrammar(n - 1, k / 2) == 0) return 1;
            else return 0;
        } else {
            if (kthGrammar(n - 1, (k + 1) / 2) == 0) return 0;
            else return 1;
        }
    }
}
