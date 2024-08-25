package edu.bit.datastructures.graph;

import java.util.Arrays;

public class DijkstraShortestPathWithEvenlyWeightedEdges {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        int[][] adjGraph = new int[n][n];
        for (int[] row : adjGraph) {
            Arrays.fill(row, 0);
        }
        for (int i = 0; i < m; i++) {
            adjGraph[edges[i][0]][edges[i][1]] = 1;
            adjGraph[edges[i][1]][edges[i][0]] = 1;
        }

        int[] dist = new int[n];
        boolean[] sptSet = new boolean[n];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < n - 1; count++) {
            // Pick the minimum distance vertex from the set
            // of vertices not yet processed. u is always
            // equal to src in first iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of
            // the picked vertex.
            for (int v = 0; v < n; v++)

                // Update dist[v] only if is not in sptSet,
                // there is an edge from u to v, and total
                // weight of path from src to v through u is
                // smaller than current value of dist[v]
                if (!sptSet[v] && adjGraph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + adjGraph[u][v] < dist[v])
                    dist[v] = dist[u] + adjGraph[u][v];
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }


    int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < dist.length; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
}