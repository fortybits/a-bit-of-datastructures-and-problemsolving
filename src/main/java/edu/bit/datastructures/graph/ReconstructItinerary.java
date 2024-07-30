package edu.bit.datastructures.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight.
 * Reconstruct the itinerary in order and return it.
 * <p>
 * All the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 * <p>
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * <p>
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 * <p>
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 */
public class ReconstructItinerary {

    // We start by building a graph and then sorting vertices in the adjacency list so that when we traverse the graph later,
    // we can guarantee the lexical order of the itinerary can be as good as possible.
    // When we have generated an itinerary, we check if we have used all our airline tickets.
    // If not, we revert the change and try another ticket. We keep trying until we have used all our tickets.

    private Map<String, List<String>> adjList = new TreeMap<>();
    private LinkedList<String> route = new LinkedList<>();
    private int numTickets = 0;
    private int numTicketsUsed = 0;

    // to find all possible itineraries we shall traverse the complete graph and find all paths in the graph,
    // DFS can be made use of in such circumstances
    public List<String> findItinerary(List<List<String>> tickets) {
        return findItinerary(tickets, "JFK");
    }

    private List<String> findItinerary(List<List<String>> tickets, String startAirport) {
        if (tickets == null || tickets.isEmpty()) return route;
        // build graph
        numTickets = tickets.size();
        adjList = createItineraryGraph(tickets);

        // sort vertices in the adjacency list so they appear in lexical order
        adjList.forEach((key, value) -> Collections.sort(value));

        // start DFS
        route.add(startAirport);
        dfsRoute(startAirport);
        return route;
    }

    private Map<String, List<String>> createItineraryGraph(List<List<String>> tickets) {
        return tickets.stream()
                .collect(Collectors.groupingBy(List::getFirst,
                        Collectors.mapping(List::getLast,
                                Collectors.toList())));
    }

    private void dfsRoute(String v) {
        // base case: vertex v is not in adjacency list
        // v is not a starting point in any itinerary(no outgoing edges),
        // or we would have visited it thus we have reached end point in our DFS
        if (!adjList.containsKey(v)) return;
        List<String> list = adjList.get(v);
        for (int i = 0; i < list.size(); ++i) {
            String neighbor = list.get(i);
            // remove ticket(route) from graph
            list.remove(i);
            route.add(neighbor);
            numTicketsUsed++;
            dfsRoute(neighbor);
            // we only return when we have used all tickets
            if (numTickets == numTicketsUsed) return;
            // otherwise we need to revert the changes and try other tickets
            list.add(i, neighbor);
            // This line took me a long time to debug
            // we must remove the last airport, since in an itinerary, the same airport can appear many times!!
            route.removeLast();
            numTicketsUsed--;
        }
    }


    public List<String> findItineraryRecursive(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.getFirst(), _ -> new PriorityQueue<>()).add(ticket.getLast());
        }

        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> nextAirports = graph.get(airport);
        while (nextAirports != null && !nextAirports.isEmpty()) {
            dfs(nextAirports.poll(), graph, itinerary);
        }
        itinerary.addFirst(airport);
    }

    public List<String> findItineraryIterative(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        LinkedList<String> stack = new LinkedList<>();
        stack.add("JFK");
        LinkedList<String> itinerary = new LinkedList<>();

        while (!stack.isEmpty()) {
            while (!graph.getOrDefault(stack.peekLast(), new PriorityQueue<>()).isEmpty()) {
                stack.add(graph.get(stack.peekLast()).poll());
            }
            itinerary.addFirst(stack.pollLast());
        }

        return itinerary;
    }
}