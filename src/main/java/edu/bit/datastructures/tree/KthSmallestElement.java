package edu.bit.datastructures.tree;

import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * <p>
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
 * and you need to find the kth smallest frequently, how would you optimize?
 */
public class KthSmallestElement {

    // inorder traversal of a binary search would place this element at index K in O(N) time complexity
    public int kthSmallest(TreeNode root, int k) {
        TreeTraversal treeTraversal = new TreeTraversal();
        List<Integer> inorder = treeTraversal.inorder(root);
        return inorder.get(k);
    }
}
