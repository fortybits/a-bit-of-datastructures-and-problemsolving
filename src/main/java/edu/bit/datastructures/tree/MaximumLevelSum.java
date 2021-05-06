package edu.bit.datastructures.tree;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
public class MaximumLevelSum {

    public int maxLevelSum(TreeNode root) {
        HeightOfTree heightOfTree = new HeightOfTree();
        int ht = heightOfTree.getHeight(root); // O(N)
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