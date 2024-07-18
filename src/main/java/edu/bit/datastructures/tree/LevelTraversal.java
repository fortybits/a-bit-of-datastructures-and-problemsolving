package edu.bit.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class LevelTraversal {

    // performs a level order traversal of a tree to print it generally
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        if (root == null) {
            return wrapList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int elementsInLevel = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < elementsInLevel; i++) {
                TreeNode currentNode = queue.peek();
                // you can traverse right to left by just changing this order
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }

    private void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height + 1);
        levelHelper(res, root.right, height + 1);
    }

    public List<Integer> flattenLevelOrder(TreeNode treeNode) {
        return levelOrderDFS(treeNode)
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}