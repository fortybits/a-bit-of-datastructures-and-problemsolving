package edu.bit.datastructures.graph;

import java.util.*;

public class DijkstraShortestPath {

    int vertices;

    public DijkstraShortestPath(int vertices) {
        this.vertices = vertices;
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }


    // Function that implements Dijkstra's single source shortest path algorithm for a graph represented using
    // adjacency matrix representation
    public void dijkstra(int[][] graph, int src) {
        int[] dist = new int[vertices]; // The output array.
        // dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in
        // shortest path tree or shortest distance from src
        // to i is finalized
        boolean[] sptSet = new boolean[vertices];

        // Initialize all distances as INFINITE and stpSet[]
        // as false
        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < vertices - 1; count++) {
            // Pick the minimum distance vertex from the set
            // of vertices not yet processed. u is always
            // equal to src in first iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of
            // the picked vertex.
            for (int v = 0; v < vertices; v++)

                // Update dist[v] only if is not in sptSet,
                // there is an edge from u to v, and total
                // weight of path from src to v through u is
                // smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
        printSolution(dist);
    }

    int minDistance(int[] dist, boolean[] sptSet) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < vertices; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance
    // array
    private void printSolution(int[] dist) {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < vertices; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    private int V;
    private List<List<IPair>> adj;


    void addEdge(int u, int v, int w) {
        adj.get(u).add(new IPair(v, w));
        adj.get(v).add(new IPair(u, w));
    }

    void shortestPath(int src) {
        PriorityQueue<IPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.second));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new IPair(0, src));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().second;

            for (IPair v : adj.get(u)) {
                if (dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second;
                    pq.add(new IPair(dist[v.first], v.first));
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    static class IPair {
        int first, second;

        IPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
