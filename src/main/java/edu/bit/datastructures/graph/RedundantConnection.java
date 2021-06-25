package edu.bit.datastructures.graph;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * <p>
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
 * The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 * The graph is represented as an array edges of length n
 * where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
 * <p>
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 */
public class RedundantConnection {
    // ann alternate approach is to make use of dfs to identify the addition of which edge brings in a cycle
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(edges.length);

        for (int[] edge : edges) {
            if (!disjointSet.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        throw new IllegalArgumentException();
    }

    static class DisjointSet {
        private final int[] parent;
        private final byte[] rank;

        public DisjointSet(int n) {
            if (n < 0) {
                throw new IllegalArgumentException();
            }
            parent = new int[n];
            rank = new byte[n];
        }

        // Return false if x, y are connected.
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }

            // Make root of smaller rank point to root of larger rank.
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }

            return true;
        }

        private int find(int x) {
            if (parent[x] == 0) {
                return x;
            }
            return parent[x] = find(parent[x]); // Path compression by halving.
        }
    }
}