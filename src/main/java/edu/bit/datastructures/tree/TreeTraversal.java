package edu.bit.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    // performs an inorder traversal of a tree and stored the vales into a list with runtime O(N)
    // Note: inorder traversal of a BST is considered to be sorted
    public List<Integer> inorder(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        if (node.left == null && node.right == null) {
            values.add(node.val);
            return values;
        }

        List<Integer> leftNodes = inorder(node.left);
        int val = node.val;
        List<Integer> rightNodes = inorder(node.right);

        values.addAll(leftNodes);
        values.add(val);
        values.addAll(rightNodes);

        return values;
    }
}