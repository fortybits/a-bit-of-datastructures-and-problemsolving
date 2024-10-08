package edu.bit.datastructures.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a graph whose nodes are 3-letter words and an array of 3-letter words. Find a path in the graph such that the difference b/w words in the path and given array is minimum.
 * <p>
 * We are given 2 APIs which work for this graph:
 * <p>
 * class Graph {
 * * Get all neighbors of a node.
 * Set<String> getNeighbors(String node);
 * * Get a list of all nodes in no particular order.
 * Set<String> listAllNodes();
 * }
 * https://leetcode.com/discuss/interview-question/378687/
 */

public class MinDiffInGraphAndPath {

    public int helper(String[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        Set<String> allNodes = listAllNodes();
        Map<String, Integer> map = new HashMap<>();
        int n = arr.length;
        //init
        for (String s : allNodes) {
            map.put(s, diff(s, arr[0]));
        }
        //dp[i][getNeighbors(j)] = dp[i - 1][j] + diff(getNeighbors(j), arr[i])
        for (int i = 1; i < n; i++) {
            Map<String, Integer> temp = new HashMap<>();
            for (String key : map.keySet()) {
                int base = map.get(key);
                for (String k : getNeighbors(key)) {
                    int curt = base + diff(arr[i], k);
                    if (temp.containsKey(k)) {
                        temp.put(k, Math.min(curt, temp.get(k)));
                    } else {
                        temp.put(k, curt);
                    }
                }
            }
            map = temp;
        }
        int ans = Integer.MAX_VALUE;
        for (int v : map.values()) {
            ans = Math.min(v, ans);
        }
        return ans;
    }

    // todo
    private static Integer diff(String s, String k) {
        return null;
    }

    Set<String> getNeighbors(String node) {
        return Set.of();
    }

    Set<String> listAllNodes() {
        return Set.of();
    }
}