package edu.bit.datastructures.tree;

import edu.bit.datastructures.array.FindSwappedPair;

import java.util.ArrayList;
import java.util.List;

/**
 * Two of the nodes of a Binary Search Tree (BST) are swapped. Identify those nodes, that have been swapped.
 * Condition of transformation:
 * - Tree structure does not change
 * - At most any 2 nodes can be swapped by value
 */
public class IdentifySwappedNodes {

    public int[] findSwapped(TreeNode node) {
        List<Integer> inorderTree = inorder(node); // inorder traversal is O(N) for the

        FindSwappedPair findSwappedPair = new FindSwappedPair();
//        return findSwappedPair.getSwappedValuesInefficiently(inorderTree);
        return findSwappedPair.findSwappedValues(inorderTree);
    }

    private List<Integer> inorder(TreeNode node) {
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