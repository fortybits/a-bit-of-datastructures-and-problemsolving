package edu.bit.problemsolving;

import edu.bit.datastructures.tree.TopVotedCandidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TopVotedCandidateTest {

    TopVotedCandidate topVotedCandidate;

    @Test
    void queryLeader() {
        topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0},
                new int[]{0, 5, 10, 15, 20, 25, 30});
        Assertions.assertEquals(0, topVotedCandidate.query(3));
        Assertions.assertEquals(1, topVotedCandidate.query(12));
        Assertions.assertEquals(1, topVotedCandidate.query(25));
        Assertions.assertEquals(0, topVotedCandidate.query(15));
        Assertions.assertEquals(0, topVotedCandidate.query(24));
        Assertions.assertEquals(1, topVotedCandidate.query(8));
        Assertions.assertEquals(0, topVotedCandidate.query(36)); // boundary test
    }

}