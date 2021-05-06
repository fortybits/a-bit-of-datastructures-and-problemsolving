package edu.bit.datastructures.tree;

/**
 * Given a binary tree, find its height. If the tree is empty, return 0.
 */
public class HeightOfTree {

    // for N nodes, we visited each of them to find their individual depth, hence this is O(N)
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(getHeight(node.right), getHeight(node.left)) + 1;
    }
}
