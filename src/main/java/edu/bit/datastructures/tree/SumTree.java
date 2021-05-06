package edu.bit.datastructures.tree;

/**
 * Given a Binary Tree. Check whether it is a Sum Tree or not.
 * <p>
 * A Binary Tree is a Sum Tree in which value of each node x is
 * equal to sum of nodes present in its left subtree and right subtree.
 * <p>
 * An empty tree is also a Sum Tree as sum of an empty tree can be considered to be 0.
 * A leaf node is also considered as a Sum Tree.
 */
public class SumTree {

    public boolean isSumTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }

        return isSumTree(root.left) && isSumTree(root.right)
                && root.val == sumOfTree(root.left) + sumOfTree(root.right);
    }

    private int sumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.left == null && root.right == null ? root.val : (root.val * 2);
    }
}
