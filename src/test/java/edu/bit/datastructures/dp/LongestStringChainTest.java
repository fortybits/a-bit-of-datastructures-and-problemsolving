package edu.bit.datastructures.dp;

import org.junit.jupiter.api.Test;

import java.util.List;

class LongestStringChainTest {

    LongestStringChain longestStringChain = new LongestStringChain();

    @Test
    void longestStrChain() {
        List<String> strings = longestStringChain.longestStrChainValues(new String[]{"a", "b", "ba", "bca", "bda", "bdca"});
        System.out.println(strings);

    }
}