package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RankTeamByVotesTest {

    RankTeamByVotes rankTeamByVotes = new RankTeamByVotes();

    @Test
    void testRankingTeams() {
        Assertions.assertEquals("ACB",
                rankTeamByVotes.rankTeamsOptimised(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
        Assertions.assertEquals("XWYZ",
                rankTeamByVotes.rankTeamsOptimised(new String[]{"WXYZ", "XYZW"}));
        Assertions.assertEquals("ZMNAGUEDSJYLBOPHRQICWFXTVK",
                rankTeamByVotes.rankTeamsOptimised(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
        Assertions.assertEquals("ABC",
                rankTeamByVotes.rankTeamsOptimised(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
    }

    @Test
    void testRankingTeamsClean() {
        Assertions.assertEquals("ACB",
                rankTeamByVotes.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
        Assertions.assertEquals("XWYZ",
                rankTeamByVotes.rankTeams(new String[]{"WXYZ", "XYZW"}));
        Assertions.assertEquals("ZMNAGUEDSJYLBOPHRQICWFXTVK",
                rankTeamByVotes.rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
        Assertions.assertEquals("ABC",
                rankTeamByVotes.rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
    }
}