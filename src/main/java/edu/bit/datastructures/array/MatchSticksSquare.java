package edu.bit.datastructures.array;

/**
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick.
 * You want to use all the matchsticks to make one square.
 * You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 * <p>
 * Return true if you can make this square and false otherwise.
 */
public class MatchSticksSquare {

    public boolean makeSquare(int[] matchsticks) {
        PartitionToKEqualSubsets partitionToKEqualSubsets = new PartitionToKEqualSubsets();
        return partitionToKEqualSubsets.partitionIntoEqualSubsets(matchsticks, 4);
    }
}