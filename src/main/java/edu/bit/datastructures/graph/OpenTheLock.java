package edu.bit.datastructures.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
 * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */
public class OpenTheLock {

    public int openLock(String[] deadEnds, String target) {
        String start = "0000";
        Set<String> deadSet = new HashSet<>();
        Collections.addAll(deadSet, deadEnds);

        // Use set instead of queue to accelerate search
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(target);
        if (target.equals(start)) {
            return 0;
        }
        // Search from begin and end simultaneously
        return deadSet.contains(start) || deadSet.contains(target) ?
                -1 : traverse(beginSet, endSet, deadSet);
    }

    public int traverse(Set<String> beginSet, Set<String> endSet, Set<String> deadSet) {
        Set<String> newSet = new HashSet<>();
        for (String current : beginSet) {
            StringBuilder sb = new StringBuilder(current);
            for (int i = 0; i < 4; i++) {
                char originalChar = current.charAt(i);

                // forward direction
                sb.setCharAt(i, (char) ((originalChar - '0' + 1) % 10 + '0'));
                if (endSet.contains(sb.toString())) {
                    return 1;
                }
                if (!deadSet.contains(sb.toString())) {
                    newSet.add(sb.toString());
                    deadSet.add(sb.toString()); // the searched elements are taken as deadend (not to get into a cycle)
                }

                // reverse direction
                sb.setCharAt(i, (char) ((originalChar - '0' + 9) % 10 + '0'));
                if (endSet.contains(sb.toString())) {
                    return 1;
                }
                if (!deadSet.contains(sb.toString())) {
                    newSet.add(sb.toString());
                    deadSet.add(sb.toString());
                }

                sb.setCharAt(i, originalChar);
            }
        }
        if (newSet.isEmpty()) {
            return -1;
        }
        beginSet = newSet;
        // Each time search from the set with less elements
        int result = beginSet.size() > endSet.size() ?
                traverse(endSet, beginSet, deadSet) :
                traverse(beginSet, endSet, deadSet);
        return result == -1 ? -1 : result + 1;
    }
}