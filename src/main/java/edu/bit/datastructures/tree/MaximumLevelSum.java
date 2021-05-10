package edu.bit.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

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
    // typical dfs implementation here
    void calculateLevelSum(TreeNode node, int level, long[] sum) {
        if (node == null) {
            return;
        }
        sum[level] = sum[level] + node.val;

        calculateLevelSum(node.left, level + 1, sum);
        calculateLevelSum(node.right, level + 1, sum);
    }

    public int maxLevelSumUsingBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int identifiedMaxLevel = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int level = 1; !q.isEmpty(); ++level) {
            int sum = 0;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode n = q.poll();
                sum += n.val;
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
            if (max < sum) {
                max = sum;
                identifiedMaxLevel = level;
            }
        }
        return identifiedMaxLevel;
    }
}