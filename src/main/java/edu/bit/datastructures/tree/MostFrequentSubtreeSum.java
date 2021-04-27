package edu.bit.datastructures.tree;

import java.util.*;

/**
 * Given the root of a binary tree, return the most frequent subtree sum.
 * If there is a tie, return all the values with the highest frequency in any order.
 * The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself).
 */
public class MostFrequentSubtreeSum {

    // find the sum at each node and persist it in a list
    // then find the most frequent element(s) of the sum list
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Long, Long> sumFrequencyMap = new HashMap<>();

        findSubTreeSumFrequency(root, sumFrequencyMap);

        TreeMap<Long, List<Long>> result = new TreeMap<>();
        for (Map.Entry<Long, Long> longLongEntry : sumFrequencyMap.entrySet()) {
            result.computeIfAbsent(longLongEntry.getValue(),
                    k -> new ArrayList<>()).add(longLongEntry.getKey());
        }
        return result.lastEntry().getValue().stream()
                .mapToInt(Long::intValue)
                .toArray();
    }

    private long findSubTreeSumFrequency(TreeNode node, Map<Long, Long> frequencyMap) {
        if (node == null) {
            return 0;
        }
        long subTreeSum = findSubTreeSumFrequency(node.left, frequencyMap) +
                findSubTreeSumFrequency(node.right, frequencyMap) +
                node.val;

        frequencyMap.merge(subTreeSum, 1L, Long::sum);
        return subTreeSum;
    }
}