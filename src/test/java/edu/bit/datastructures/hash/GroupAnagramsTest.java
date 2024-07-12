package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GroupAnagramsTest {

    GroupAnagrams groupAnagrams = new GroupAnagrams();

    @Test
    void testGroupingAnagrams() {
//        Assertions.assertEquals(List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea")),
//                groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        Assertions.assertEquals(List.of(List.of("")), groupAnagrams.groupAnagrams(new String[]{""}));

        Assertions.assertEquals(List.of(List.of("a")), groupAnagrams.groupAnagrams(new String[]{"a"}));
    }

}