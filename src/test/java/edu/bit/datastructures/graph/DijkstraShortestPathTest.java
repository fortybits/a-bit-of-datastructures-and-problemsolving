package edu.bit.datastructures.graph;

import org.junit.jupiter.api.Test;

class DijkstraShortestPathTest {

    @Test
    void printShortestPaths() {
        int[][] graph = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        int vertices = graph[0].length;
        DijkstraShortestPath shortestPath = new DijkstraShortestPath(vertices);

        for (int i = 0; i < vertices; i++) {
            shortestPath.dijkstra(graph, i); // from each node
        }
    }
}