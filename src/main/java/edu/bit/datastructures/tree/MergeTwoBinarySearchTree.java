package edu.bit.datastructures.tree;

import edu.bit.datastructures.array.MergeArrays;

import java.util.List;

/**
 * Given two BSTs, return elements of both BSTs in sorted form.
 * Expected Time Complexity: O(M+N) where M and N are the sizes if the two BSTs.
 * Expected Auxiliary Space: O(Height of BST1 + Height of BST2).
 */
public class MergeTwoBinarySearchTree {

    private final TreeTraversal treeTraversal = new TreeTraversal();
    private final MergeArrays mergeArrays = new MergeArrays();

    public List<Integer> mergeBST(TreeNode first, TreeNode second) {
        List<Integer> nodes = treeTraversal.inorder(first); // space O(M), time O(M)
        List<Integer> otherNodes = treeTraversal.inorder(second); // space O(N), time O(N)
        return mergeArrays.mergeListsToSortedResult(nodes, otherNodes); // space O(N+M), time O(M+N)
    }

}