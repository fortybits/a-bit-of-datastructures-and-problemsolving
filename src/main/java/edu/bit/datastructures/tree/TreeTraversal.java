package edu.bit.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

    // performs an inorder traversal of a tree and stored the vales into a list with runtime O(N)
    // Note: inorder traversal of a BST is considered to be sorted
    public List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        if (root.left == null && root.right == null) {
            values.add(root.val);
            return values;
        }

        List<Integer> leftNodes = inorder(root.left);
        int val = root.val;
        List<Integer> rightNodes = inorder(root.right);

        values.addAll(leftNodes);
        values.add(val);
        values.addAll(rightNodes);

        return values;
    }

    public List<Integer> preorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> values = new ArrayList<>();
        if (root.left == null && root.right == null) {
            values.add(root.val);
            return values;
        }

        int val = root.val;
        List<Integer> leftNodes = preorder(root.left);
        List<Integer> rightNodes = preorder(root.right);

        values.add(val);
        values.addAll(leftNodes);
        values.addAll(rightNodes);
        return values;
    }


    public List<Integer> postorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> values = new ArrayList<>();
        if (root.left == null && root.right == null) {
            values.add(root.val);
            return values;
        }

        List<Integer> leftNodes = preorder(root.left);
        List<Integer> rightNodes = preorder(root.right);
        int val = root.val;

        values.addAll(leftNodes);
        values.addAll(rightNodes);
        values.add(val);
        return values;
    }
}