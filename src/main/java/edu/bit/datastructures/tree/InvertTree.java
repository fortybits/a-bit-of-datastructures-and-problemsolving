package edu.bit.datastructures.tree;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode swap = root.right;
        root.right = root.left;
        root.left = swap;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}
