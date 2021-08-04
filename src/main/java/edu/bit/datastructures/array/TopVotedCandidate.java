package edu.bit.datastructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * In an election, the i-th vote was cast for persons[i] at time times[i].
 * <p>
 * Now, we would like to implement the following query function:
 * TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.
 * <p>
 * Votes cast at time t will count towards our query.
 * In the case of a tie, the most recent vote (among tied candidates) wins.
 */
public class TopVotedCandidate {

    Map<Integer, Integer> timeToLeadMapping = new HashMap<>();
    int[] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        int lead = -1;
        Map<Integer, Integer> count = new HashMap<>();
        time = times;
        for (int i = 0; i < persons.length; ++i) {
            count.merge(persons[i], 1, Integer::sum);
            if (i == 0 || count.get(persons[i]) >= count.get(lead)) {
                lead = persons[i];
            }
            timeToLeadMapping.put(times[i], lead);
        }
    }

    public int q(int t) {
        int i = Arrays.binarySearch(time, t);
        return i < 0 ? timeToLeadMapping.get(time[-i - 2]) :
                timeToLeadMapping.get(time[i]);
    }
}