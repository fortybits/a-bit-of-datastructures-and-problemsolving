package edu.bit.datastructures.graph;

public class Graph {
    public static int MAX_VERTICES = 6;
    public int count;
    GraphNode[] nodes;

    public Graph() {
        nodes = new GraphNode[MAX_VERTICES];
        count = 0;

    }

    public GraphNode[] getNodes() {
        return nodes;
    }

    public void addNode(GraphNode x) {
        if (count < nodes.length) {
            nodes[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }

    static class GraphNode {
        private final String vertex;
        public int adjacentCount;
        int data;
        State state;
        GraphNode[] adjacent;

        public GraphNode(String vertex, int adjacentLength) {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new GraphNode[adjacentLength];
        }

        public void addAdjacent(GraphNode x) {
            if (adjacentCount < adjacent.length) {
                this.adjacent[adjacentCount] = x;
                adjacentCount++;
            } else {
                System.out.print("No more adjacent can be added");
            }
        }
    }
}