package edu.bit.datastructures.tree;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">minimum depth of binary tree</a>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 */
public class MinimalDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    public int optimisedMinDepth(TreeNode root) {
        if (root == null) return 0;
        calculateDepth(root);
        return minDepth;
    }

    private int minDepth = Integer.MAX_VALUE;
    private int currentDepth = 0;

    private void calculateDepth(TreeNode node) {
        currentDepth++;
        if (currentDepth == minDepth) {
            currentDepth--;
            return;
        }
        if (node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, currentDepth);
            currentDepth--;
            return;
        }
        if (node.left != null && (node.right == null || node.right.left != null || node.right.right != null)) {
            calculateDepth(node.left);
        }
        if (node.right != null) {
            calculateDepth(node.right);
        }
        currentDepth--;
    }
}