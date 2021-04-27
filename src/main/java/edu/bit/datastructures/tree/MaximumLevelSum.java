package edu.bit.datastructures.tree;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
public class MaximumLevelSum {

    public int maxLevelSum(TreeNode root) {
        int ht = getHeight(root); // O(N)
        long[] perLevelSum = new long[ht];
        calculateLevelSum(root, 0, perLevelSum); // O(N)
        return maxLevelSum(perLevelSum) + 1; // O(K)
    }

    private int maxLevelSum(long[] perLevelSum) {
        long max = Long.MIN_VALUE;
        int level = 0;
        for (int i = 0; i < perLevelSum.length; i++) {
            long v = perLevelSum[i];
            if (max < v) {
                max = v;
                level = i;
            }
        }
        return level;
    }

    // for N nodes, we visited each of them to find their individual depth, hence this is O(N)
    int getHeight(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = 0;
        if (root.left != null) {
            left = getHeight(root.left);
        }

        int right = 0;
        if (root.right != null) {
            right = getHeight(root.right);
        }

        return (Math.max(left, right) + 1);
    }

    // this is also visited per each TreeNode to fill in the sum, hence O(N)
    void calculateLevelSum(TreeNode node, int level, long sum[]) {
        if (node == null) {
            return;
        }
        sum[level] = sum[level] + node.val;

        calculateLevelSum(node.left, level + 1, sum);
        calculateLevelSum(node.right, level + 1, sum);
    }
}