package edu.bit.datastructures.graph;

import java.util.*;

/**
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 * <p>
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target.
 * You can travel between bus stops by buses only.
 * <p>
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 */
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> routeMap = constructRouteLookup(routes);

        Queue<int[]> bfs = new ArrayDeque<>();
        bfs.offer(new int[]{source, 0});

        Set<Integer> seen = new HashSet<>();
        seen.add(source);

        boolean[] seenRoutes = new boolean[routes.length];

        while (!bfs.isEmpty()) {
            int[] currentStop = bfs.poll();
            int stop = currentStop[0];
            int busCount = currentStop[1];
            if (stop == target) return busCount;

            for (int i : routeMap.get(stop)) {
                if (seenRoutes[i]) continue;
                for (int j : routes[i]) {
                    if (!seen.contains(j)) {
                        seen.add(j);
                        bfs.offer(new int[]{j, busCount + 1});
                    }
                }
                seenRoutes[i] = true;
            }
        }
        return -1;
    }

    private static Map<Integer, Set<Integer>> constructRouteLookup(int[][] routes) {
        Map<Integer, Set<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int j : routes[i]) {
                routeMap.computeIfAbsent(j, k -> new HashSet<>()).add(i);
            }
        }
        return routeMap;
    }
}