package edu.bit.problemsolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given two integer arrays persons and times. In an election, the ith vote was cast for persons[i] at time times[i].
 * <p>
 * For each query at a time t, find the person that was leading the election at time t.
 * Votes cast at time t will count towards our query. In the case of a tie, the most recent vote (among tied candidates) wins.
 * <p>
 * Implement the TopVotedCandidate class:
 * <p>
 * TopVotedCandidate(int[] persons, int[] times) Initializes the object with the persons and times arrays.
 * int q(int t) Returns the number of the person that was leading the election at time t according to the mentioned rules.
 */
public class TopVotedCandidate {

    Map<Integer, Integer> lookUpMatrix = new HashMap<>();
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length;
        int leader = -1;
        Map<Integer, Integer> count = new HashMap<>(); // person to vote count
        time = times;
        for (int i = 0; i < n; ++i) { // O(N)
            Integer finalValue = count.merge(persons[i], 1, Integer::sum); // upgraded
            if (i == 0 || finalValue >= count.get(leader)) {
                leader = persons[i];
            }
            lookUpMatrix.put(times[i], leader);
        }
    }

    public int query(int t) {
        int i = Arrays.binarySearch(time, t); // O(log(N))
        return i < 0 ? lookUpMatrix.get(time[-i - 2]) : lookUpMatrix.get(time[i]);
        // The insertion point is defined as the point at which the key would be inserted into the array:
        // the index of the first element greater than the key,
        // or a. length if all elements in the array are less than the specified key
    }
}