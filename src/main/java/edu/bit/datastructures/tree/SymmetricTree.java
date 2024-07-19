package edu.bit.datastructures.tree;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

    // one of the approach would be to perform an inorder traversal of the tree and compare
    // first half with second pivoted around the root
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricHelp(left.left, right.right)
                && isSymmetricHelp(left.right, right.left);
    }
}
