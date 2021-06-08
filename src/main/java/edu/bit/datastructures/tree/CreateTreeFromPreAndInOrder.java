package edu.bit.datastructures.tree;

import java.util.Arrays;

public class CreateTreeFromPreAndInOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(inorder, preorder, 0, inorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] inorder, int[] preOrder, int inStart, int inEnd, int preStart) {
        if (inStart > inEnd || preStart > preOrder.length - 1) {
            return null; // cases when inorder start
        }
        /* choose current node from Preorder traversal using preIndex and increment preIndex */
        TreeNode tNode = new TreeNode(preOrder[preStart]);

        /* If this node has no children then return */
        if (inStart == inEnd) {
            return tNode;
        }
        /* Else find the index of this node in Inorder traversal */
        int inIndex = Arrays.binarySearch(inorder, inStart, inEnd, tNode.val);

        /* Using index in Inorder traversal, construct left and right sub-trees */
        tNode.left = buildTree(inorder, preOrder, inStart, inIndex - 1, preStart + 1);
        tNode.right = buildTree(inorder, preOrder, inIndex + 1, inEnd, preStart + inIndex - inStart + 1);

        return tNode;
    }


    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}