package edu.bit.datastructures.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a special ranking system, each voter gives a rank from highest to
 * lowest to all teams participated in the competition.
 * <p>
 * The ordering of teams is decided by who received the most position-one votes.
 * If two or more teams tie in the first position, we consider the second position to resolve the conflict,
 * if they tie again, we continue this process until the ties are resolved.
 * <p>
 * If two or more teams are still tied after considering all positions,
 * we rank them alphabetically based on their team letter.
 * <p>
 * Given an array of strings votes which is the votes of all voters in the ranking systems.
 * Sort all teams according to the ranking system described above.
 * <p>
 * Return a string of all teams sorted by the ranking system.
 */
public class RankTeamByVotes {

    // N votes with M characters
    public String rankTeams(String[] votes) {
        if (votes.length == 0) {
            return "No votes registered!";
        }
        Map<Character, Map<Integer, Long>> teamPositionFrequency = new HashMap<>();
        int totalTeams = votes[0].length();
        List<Character> allTeams = new ArrayList<>();

        for (Character team : votes[0].toCharArray()) {
            allTeams.add(team);
            teamPositionFrequency.put(team, new HashMap<>());
            for (int i = 0; i < totalTeams; i++) {
                teamPositionFrequency.get(team).put(i, 0L);
            }
        }

        // M*N complexity to get the frequency
        for (String vote : votes) {
            for (int i = 0; i < totalTeams; i++) {
                char team = vote.charAt(i);
                Long currentFrequency = teamPositionFrequency.get(team).get(i);
                teamPositionFrequency.get(team).put(i, currentFrequency + 1);
            }
        }

        allTeams.sort((a, b) -> {
            for (int i = 0; i < votes[0].length(); i++) {
                if (!teamPositionFrequency.get(a).get(i).equals(teamPositionFrequency.get(b).get(i))) {
                    return Long.compare(teamPositionFrequency.get(b).get(i), teamPositionFrequency.get(a).get(i));
                }
            }
            return Character.compare(a, b);
        });

        StringBuilder sb = new StringBuilder();
        for (char c : allTeams) {
            sb.append(c);
        }
        return sb.toString();
    }

    // this is slightly space and runtime optimised
    public String rankTeamsOptimised(String[] votes) {
        if (votes.length == 0) {
            return null;
        }
        Map<Character, int[]> teamPositionFrequency = new HashMap<>();
        int totalTeams = votes[0].length();

        // M*N complexity to get the frequency
        for (String vote : votes) {
            for (int i = 0; i < totalTeams; i++) {
                char team = vote.charAt(i);
                teamPositionFrequency.putIfAbsent(team, new int[totalTeams]);
                teamPositionFrequency.get(team)[i]++;
            }
        }

        List<Character> orderedTeams = new ArrayList<>(teamPositionFrequency.keySet());

        orderedTeams.sort((a, b) -> {
            for (int i = 0; i < totalTeams; i++) {
                if (teamPositionFrequency.get(a)[i] != teamPositionFrequency.get(b)[i]) {
                    return Integer.compare(teamPositionFrequency.get(b)[i], teamPositionFrequency.get(a)[i]);
                }
            }
            return Character.compare(a, b);
        });

        StringBuilder sb = new StringBuilder();
        for (char c : orderedTeams) {
            sb.append(c);
        }
        return sb.toString();
    }
}