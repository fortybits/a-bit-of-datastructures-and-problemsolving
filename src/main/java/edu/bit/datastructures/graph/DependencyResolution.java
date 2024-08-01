package edu.bit.datastructures.graph;

import java.util.*;

/**
 * Given a list of package dependencies write these two algorithms
 * 1. ArePackagesInstallable
 * 2. GetInstallOrder of a given package
 * <p>
 * Package: can be considered as a software dependency
 * Installable: There should not be a cycle between e.g. P0 and P2
 * <p>
 * <p>
 * // P0 -> P1 [P4, P3, P1, P0]
 * // P1-> P3, P4 [P4, P3, P1]
 * <p>
 * // P5 -> P6, P3  -> [P4]
 * // P6 -> P4, P8, P9
 */
public class DependencyResolution {

    Map<String, List<String>> dependencyGraph = new HashMap<>();

    private void buildGraph(String[][] dependencies) {
        dependencyGraph = new HashMap<>();
    }

    boolean arePackagesInstallable(String[][] dependencies) {
        if (dependencyGraph.isEmpty()) return true;
        Set<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        List<String> nodesHavingDependencies = new ArrayList<>(dependencyGraph.keySet());


        for (String node : nodesHavingDependencies) { //
            if (visited.contains(node)) continue; // this is to handle disconnected graphs
            queue.add(node);
            while (!queue.isEmpty()) {
                String currentNode = queue.pop();
                visited.add(currentNode);
                List<String> dependents = dependencyGraph.getOrDefault(node, new ArrayList<>());
                for (String dependent : dependents) {
                    if (visited.contains(dependent)) return false;
                    else {
                        queue.add(dependent);
                    }
                }
            }

        }
        return true;
    }

    public List<String> getInstallOrderOfaPackage(String[][] dependencies, String initialDependency) {
        if (!dependencyGraph.containsKey(initialDependency)) return Collections.emptyList();
        // leaf node same as itself
        if (dependencyGraph.get(initialDependency).isEmpty()) return List.of(initialDependency);

        List<String> result = new ArrayList<>();
        // validate inital dependency exists
        List<String> toBeVistedNodes = new ArrayList<>(); // queue
        List<String> dependents = dependencyGraph.getOrDefault(initialDependency, new ArrayList<>());
        for (String depend : dependents) {
            if (dependencyGraph.get(depend).isEmpty()) {
                result.add(depend);
                dependents.remove(depend);
            } else {
                toBeVistedNodes.add(depend);
            }
        }
        // List<String> leafNodes = queue.add(node);

        return result;
    }
}