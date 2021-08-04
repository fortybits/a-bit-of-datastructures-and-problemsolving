package edu.bit.datastructures.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of candidates, find the winner only.
 * Also for handling a tie, the candidate (out of all the candidates who had the same vote count),
 * who secured highest votes first should be the winner. Example:
 * String [] candidates = {"A", "C", "E", "B", "A", "B", "C", "B", "D", "B", "A"};
 * Method to be exposed: String findWinner(String [] candidates);
 * This should return B
 */
public class CandidateWinner {

    public String findWinner(String[] candidates) {
        Map<String, Long> candidateFrequency = new HashMap<>();
        String winner = null;
        for (int i = 0, candidatesLength = candidates.length; i < candidatesLength; i++) {
            String candidate = candidates[i];
            if (i == 0 || candidateFrequency.getOrDefault(candidate, 0L) > candidateFrequency.get(winner)) {
                winner = candidate;
            }
            candidateFrequency.merge(candidate, 1L, Long::sum);
        }
        return winner;
    }
}